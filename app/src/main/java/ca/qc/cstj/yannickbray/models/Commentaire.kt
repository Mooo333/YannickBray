package ca.qc.cstj.yannickbray.models

import kotlinx.serialization.Serializable

//  À la fin de la classe : java.io.Serializable. Ça sert à partager les infos d'un fragment à un autre
@Serializable
data class Commentaire(val nom:String, val dateCommentaire: String, val message:String, val etoile:Int)   : java.io.Serializable