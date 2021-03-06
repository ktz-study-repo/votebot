package com.lejoow.votebot.vote.impl.entity.ces

import java.util.UUID

import com.lightbend.lagom.scaladsl.persistence.PersistentEntity.ReplyType
import play.api.libs.json.{Format, Json}
import com.lejoow.votebot.commons.JsonUtils._
import com.lejoow.votebot.vote.api.GenderEnum.Gender

/**
  * Created by Joo on 5/5/2017.
  */
sealed trait VoterCmd

case object GetVoterCmd extends VoterCmd with ReplyType[VoterState] {
  implicit val format: Format[GetVoterCmd.type] = singletonFormat(GetVoterCmd)
}

case class RegisterVoterCmd(residentId: String,
                            city: String,
                            gender: Gender,
                            age: Int) extends VoterCmd with ReplyType[Option[UUID]]

object RegisterVoterCmd {
  implicit val format: Format[RegisterVoterCmd] = Json.format
}