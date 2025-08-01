import axios from "axios";
import { useEffect, useState } from "react";
import { useDispatch } from "react-redux";
import { useNavigate, Link } from 'react-router-dom';
import loginvalidation from "../loginvalidation";
import swal from 'sweetalert';
import admin from "../images/admin.png";
import { API_BASE } from "../config";

function AdminLogin() {
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const [user, setUser] = useState({
        email: "",
        password: ""
    });
    const [submitted, setSubmitted] = useState(false);
    const [errors, setErrors] = useState({});

    const handleInput = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };

    const handleSubmit = e => {
        e.preventDefault();
        setErrors(loginvalidation(user));
        setSubmitted(true);
    };

    useEffect(() => {
        if (Object.keys(errors).length === 0 && submitted) {
            axios.post(`${API_BASE}/api/admin/validate`, user)
                .then(resp => {
                    let result = resp.data.data;
                    sessionStorage.setItem("email", result.email);
                    sessionStorage.setItem("uname", result.uname);
                    sessionStorage.setItem("role", "admin");
                    swal({
                        title: "✅ Success!",
                        text: "Login Successful!",
                        icon: "success",
                        button: "OK",
                    });
                    dispatch({ type: 'IsLoggedIn' });
                    navigate('/aprofile');
                })
                .catch(() => {
                    swal({
                        title: "❌ Error!",
                        text: "Invalid username or password",
                        icon: "error",
                        button: "OK",
                    });
                });
        }
    }, [errors]);

    return (
        <div className="container mt-5 d-flex justify-content-center">
            <div className="card shadow-lg border-0 rounded-4 w-75">
                <div className="row g-0">
                    {/* Left Side Image */}
                    <div className="col-md-5 d-flex align-items-center justify-content-center bg-light p-4">
                        <img
                            src={admin}
                            alt="Admin Login"
                            className="img-fluid rounded"
                            style={{ maxHeight: "300px" }}
                        />
                    </div>

                    {/* Right Side Form */}
                    <div className="col-md-7 p-5">
                        <h2 className="fw-bold text-center mb-4 text-primary">
                            Admin Login
                        </h2>
                        <form onSubmit={handleSubmit}>
                            {/* Email Field */}
                            <div className="mb-3">
                                <label className="form-label fw-semibold">
                                    <i className="fa fa-envelope me-2 text-primary"></i>Email Address
                                </label>
                                <input
                                    type="text"
                                    name="email"
                                    value={user.email}
                                    onChange={handleInput}
                                    className={`form-control ${errors.email ? "is-invalid" : ""}`}
                                    placeholder="Enter your email"
                                />
                                {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                            </div>

                            {/* Password Field */}
                            <div className="mb-3">
                                <label className="form-label fw-semibold">
                                    <i className="fa fa-lock me-2 text-primary"></i>Password
                                </label>
                                <input
                                    type="password"
                                    name="password"
                                    value={user.password}
                                    onChange={handleInput}
                                    className={`form-control ${errors.password ? "is-invalid" : ""}`}
                                    placeholder="Enter your password"
                                />
                                {errors.password && <div className="invalid-feedback">{errors.password}</div>}
                            </div>

                            {/* Forgot Password */}
                            <div className="text-end mb-3">
                                <Link to="/forgetPasswordAdmin" className="text-decoration-none text-primary">
                                    Forgot password?
                                </Link>
                            </div>

                            {/* Submit Button */}
                            <button className="btn btn-primary w-100 py-2 fw-bold">
                                <i className="fa fa-sign-in me-2"></i>Login Now
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default AdminLogin;
