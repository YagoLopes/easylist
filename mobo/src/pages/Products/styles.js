import { StyleSheet } from "react-native";

const styeles = StyleSheet.create({
  contrainer: {
    flex: 1,
    justifyContent: "center",
    backgroundColor: "#D8D8D8"
  },
  titulo: {
    fontSize: 20,
    color: "#115B74"
  },

  nav: {
    flexDirection: "row",
    justifyContent: "center",
    alignItems: "center",
    alignSelf: "center",
    width: "100%",
    paddingHorizontal: 30,
    paddingTop: 30
  },

  conversation: {
    marginTop: 5
  },

  group: {
    padding: 20,
    flexDirection: "row",
    width: "100%",
    justifyContent: "space-between"
  },
  listaTitulo: {
    fontSize: 25
  },
  butons: {
    width: "100%",
    flexDirection: "row",
    justifyContent: "space-evenly"
  },

  btnCircle: {
    width: 30,
    height: 30,
    borderRadius: 15,
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#115B74"
  },
  iconCircle: {
    fontSize: 15,
    color: "#fff"
  },
  iconMinus: {
    fontSize: 15,
    color: "#fff"
  },
  btnMinus: {
    width: 30,
    height: 30,
    borderRadius: 15,
    alignItems: "center",
    justifyContent: "center",
    backgroundColor: "#115B74"
  },

  lista: {
    backgroundColor: "#fff",
    marginTop: 20,
    alignItems: "center",
    flexDirection: "column",
    justifyContent: "space-between"
  },
  valor: {
    flexDirection: "row"
  },
  infoValor: {
    fontWeight: "bold"
  },

  footer: {
    height: 95,

    backgroundColor: "#115B74",
    width: "100%",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    paddingHorizontal: 30
  },
  footerText: {
    color: "#fff",
    marginTop: 10
  },

  btnCad: {
    height: 35,
    fontSize: 16,
    paddingHorizontal: 30,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 20,
    borderWidth: 2,
    borderColor: "#fff"
  },
  btnCadText: {
    fontSize: 16,
    color: "#fff"
  },
  btnCance: {
    height: 40,
    fontSize: 16,
    paddingHorizontal: 30,
    justifyContent: "center",
    alignItems: "center"
  },
  btnCanceText: {
    fontSize: 16,
    color: "#E49600"
  }
});

export default styeles;
