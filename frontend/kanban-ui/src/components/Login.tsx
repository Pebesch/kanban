import {type FunctionComponent, useState} from "react";

const Login: FunctionComponent = () => {
    const [message, setMessage] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const login = async () => {
        const url = "http://localhost:8080/users/login";
        const payload = {
            username,
            password
        };

        try {
            const res = await fetch(url, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload)
            });

            if (!res.ok) throw new Error(`HTTP error: ${res.status}`);

            const json = await res.json();
            setMessage(json);
        } catch (err) {
            console.error("Failed to add board:", err);
        }
    }

    return (
        <>
            <h2>Register</h2>
            <p>{message}</p>
            <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
            <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
            <button onClick={login}>Login</button>
        </>
    );

}

export default Login;