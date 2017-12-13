package weasley

import java.time.LocalDateTime

trait TimeStamp {
  var _timestamp: LocalDateTime = null
  def timestamp = _timestamp
  def timestamp_= (timestamp: LocalDateTime) : Unit = _timestamp = timestamp

  def appendTimeStampToString: String = s" @($timestamp)"
}