import { createAppContainer, createDrawerNavigator } from "react-navigation";
import Login from "./pages/Login";
import CreateUser from "./pages/createUser";
import AddList from "./pages/AddList";
import Lists from "./pages/Lists";
import Products from "./pages/Products";
import AddProducts from "./pages/AddProducts";

const Routes = createAppContainer(
  createDrawerNavigator({
    Login,
    Lists,
    AddList,
    Products,
    AddProducts,
    CreateUser
  })
);

export default Routes;
