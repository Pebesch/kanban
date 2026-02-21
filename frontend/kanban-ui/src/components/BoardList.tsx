import {type FunctionComponent, useEffect, useState} from "react";

interface KanbanBoard {
    id: string;
    name: string;
}

const BoardList: FunctionComponent = () => {
    const [boards, setBoards] = useState<KanbanBoard[]>([]);
    const [newBoard, setNewBoard] = useState("");

    useEffect(() => {
        const url = "http://localhost:8080/boards";
        fetch(url)
            .then(res => res.json())
            .then(json => {
                console.log(json);
                setBoards(json);
            })
    }, []);

    const addNew = async () => {
        const url = "http://localhost:8080/boards";
        const payload = {
            name: newBoard  // removed id, let the backend generate it
        };

        try {
            const res = await fetch(url, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload)
            });

            if (!res.ok) throw new Error(`HTTP error: ${res.status}`);

            const json = await res.json();
            setBoards(prev => [...prev, json]);
        } catch (err) {
            console.error("Failed to add board:", err);
        }
    };

    return (
        <>
            <h2>
                Boards
            </h2>
            {
                boards.map((board) => {
                    return <p key={board.id}>Board: {board.name}</p>
                })
            }
            <input type="text" onChange={e => setNewBoard(e.target.value)} value={newBoard} />
            <button onClick={addNew}>+ Add new Board</button>
        </>
    );
};

export default BoardList;