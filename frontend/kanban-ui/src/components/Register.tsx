import {type FunctionComponent, useState} from "react";

const Register: FunctionComponent = () => {
    const [message, setMessage] = useState("");
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [passwordConfirmation, setPasswordConfirmation] = useState("");

    const register = async () => {
        const url = "http://localhost:8080/users/register";
        const payload = {
            username,
            password,
            passwordConfirmation
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
            <input type="password" value={passwordConfirmation} onChange={e => setPasswordConfirmation(e.target.value)} />
            <button onClick={register}>Register</button>
        </>
    );

}

export default Register;