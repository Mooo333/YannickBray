package ca.qc.cstj.yannickbray.models

import kotlinx.serialization.Serializable

//  À la fin de la classe : java.io.Serializable. Ça sert à partager les infos d'un fragment à un autre
@Serializable
data class Livre(val titre:String,val href:String , val prix:String, val auteur:String, val categorie:String, val ISBN:String, val commentaires:List<Commentaire>) : java.io.Serializable