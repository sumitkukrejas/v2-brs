import { TbBus } from "react-icons/tb";
import { Link } from "react-router-dom";
const LoginNavbar = () => {
  return (
    <nav className="items-center flex">
      <div className="flex gap-2">
        <div className="text-4xl ml-2">
          <TbBus />
        </div>
        <div className="font-bold text-2xl">
          <Link to="/home">Bus Adda</Link>
        </div>
      </div>
      <div className="">
        <ul className="flex gap-7 font-bold text-cyan-700 pl-10 py-4">
          <li className="relative group ">
            <Link className="pb-1 active:text-white" to="/login">
              Sign in
            </Link>
            <div className="group-hover:flex hidden h-1 w-full bg-red-600 absolute"></div>
          </li>
          <li className="relative group">
            <Link className="pb-1 active:text-white" to="/register">
              Sign up
            </Link>
            <div className="group-hover:flex hidden h-1 w-full bg-red-600 absolute"></div>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default LoginNavbar;
