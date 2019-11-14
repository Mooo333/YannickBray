package ca.qc.cstj.yannickbray.models

import kotlinx.serialization.Serializable

//  À la fin de la classe : java.io.Serializable. Ça sert à partager les infos d'un fragment à un autre
@Serializable
data class Succursale(val _id: String,val appelatif: String,val addresse: String,val ville: String,val codePostal: String,val province: String,val telephone: String,val telecopieur: String,val information: String) : java.io.Serializable