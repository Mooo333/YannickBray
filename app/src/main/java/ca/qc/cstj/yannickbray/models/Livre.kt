package ca.qc.cstj.yannickbray.models

import kotlinx.serialization.Serializable

//  À la fin de la classe : java.io.Serializable. Ça sert à partager les infos d'un fragment à un autre
@Serializable
data class Livre(val prix:String, val Auteur:String, val categorie: Categorie, val ISBN:String) : java.io.Serializable