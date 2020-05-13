import { StyleSheet } from "react-native";

const styeles = StyleSheet.create({
  contrainer: {
    flex: 1,
    justifyContent: "center",
    backgroundColor: "#115B74",
    paddingHorizontal: 10
  },
  titulo: {
    fontSize: 20,
    color: "#fff"
  },
  nav: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    alignSelf: "center",
    width: "100%",
    paddingHorizontal: 30,
    paddingTop: 30
  },
  add: {
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "green",
    borderRadius: 50,
    width: 35,
    height: 35
  },
  conversation: {
    marginTop: 20
  },

  icon: {
    color: "#fff",
    fontSize: 20
  },
  butons: {
    flexDirection: "row"
  },
  btnTools: {
    height: 20,
    width: 20,
    borderRadius: 30,
    backgroundColor: "blue",
    alignItems: "center",
    justifyContent: "center",
    marginLeft: 20
  },
  btnTrash: {
    height: 20,
    width: 20,
    borderRadius: 30,
    backgroundColor: "red",
    alignItems: "center",
    justifyContent: "center"
  },
  iconTrash: {
    color: "#fff"
  },
  iconTools: {
    color: "#fff"
  },

  group: {
    padding: 20
  },
  nameList: {
    fontSize: 25
  },

  lista: {
    backgroundColor: "#fff",
    borderRadius: 30,
    marginTop: 30,
    alignItems: "center",
    flexDirection: "row",
    justifyContent: "space-between",
    paddingHorizontal: 20
  },
  footer: {
    width: "100%",
    flexDirection: "row",
    alignItems: "center",
    justifyContent: "center",
    height: 95
  },
  sairText: {
    color: "#fff"
  }
});

export default styeles;
