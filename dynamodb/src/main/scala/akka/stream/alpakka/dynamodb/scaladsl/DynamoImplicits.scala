/*
 * Copyright (C) 2016-2017 Lightbend Inc. <http://www.lightbend.com>
 */

package akka.stream.alpakka.dynamodb.scaladsl

import akka.stream.alpakka.dynamodb.AwsOp
import akka.stream.alpakka.dynamodb.impl.DynamoProtocol
import com.amazonaws.services.dynamodbv2.model._

object DynamoImplicits extends DynamoProtocol {

  implicit class BatchGetItem(val request: BatchGetItemRequest) extends AwsOp {
    override type A = BatchGetItemRequest
    override type B = BatchGetItemResult
    override val handler = batchGetItemU
    override val marshaller = batchGetItemM
    def toOp: BatchGetItem = this
  }

  implicit class CreateTable(val request: CreateTableRequest) extends AwsOp {
    override type A = CreateTableRequest
    override type B = CreateTableResult
    override val handler = createTableU
    override val marshaller = createTableM
    def toOp: CreateTable = this
  }

  implicit class DeleteItem(val request: DeleteItemRequest) extends AwsOp {
    override type A = DeleteItemRequest
    override type B = DeleteItemResult
    override val handler = deleteItemU
    override val marshaller = deleteItemM
    def toOp: DeleteItem = this
  }

  implicit class DeleteTable(val request: DeleteTableRequest) extends AwsOp {
    override type A = DeleteTableRequest
    override type B = DeleteTableResult
    override val handler = deleteTableU
    override val marshaller = deleteTableM
    def toOp: DeleteTable = this
  }

  implicit class DescribeLimits(val request: DescribeLimitsRequest) extends AwsOp {
    override type A = DescribeLimitsRequest
    override type B = DescribeLimitsResult
    override val handler = describeLimitsU
    override val marshaller = describeLimitsM
    def toOp: DescribeLimits = this
  }

  implicit class DescribeTable(val request: DescribeTableRequest) extends AwsOp {
    override type A = DescribeTableRequest
    override type B = DescribeTableResult
    override val handler = describeTableU
    override val marshaller = describeTableM
    def toOp: DescribeTable = this
  }

  implicit class Query(val request: QueryRequest) extends AwsOp {
    override type A = QueryRequest
    override type B = QueryResult
    override val handler = queryU
    override val marshaller = queryM
    def toOp: Query = this
  }

  implicit class Scan(val request: ScanRequest) extends AwsOp {
    override type A = ScanRequest
    override type B = ScanResult
    override val handler = scanU
    override val marshaller = scanM
    def toOp: Scan = this
  }

  implicit class UpdateItem(val request: UpdateItemRequest) extends AwsOp {
    override type A = UpdateItemRequest
    override type B = UpdateItemResult
    override val handler = updateItemU
    override val marshaller = updateItemM
    def toOp: UpdateItem = this
  }

  implicit class UpdateTable(val request: UpdateTableRequest) extends AwsOp {
    override type A = UpdateTableRequest
    override type B = UpdateTableResult
    override val handler = updateTableU
    override val marshaller = updateTableM
    def toOp: UpdateTable = this
  }

  implicit class PutItem(val request: PutItemRequest) extends AwsOp {
    override type A = PutItemRequest
    override type B = PutItemResult
    override val handler = putItemU
    override val marshaller = putItemM
    def toOp: PutItem = this
  }

  implicit class BatchWriteItem(val request: BatchWriteItemRequest) extends AwsOp {
    override type A = BatchWriteItemRequest
    override type B = BatchWriteItemResult
    override val handler = batchWriteItemU
    override val marshaller = batchWriteItemM
    def toOp: BatchWriteItem = this
  }

  implicit class GetItem(val request: GetItemRequest) extends AwsOp {
    override type A = GetItemRequest
    override type B = GetItemResult
    override val handler = getItemU
    override val marshaller = getItemM
    def toOp: GetItem = this
  }

  implicit class ListTables(val request: ListTablesRequest) extends AwsOp {
    override type A = ListTablesRequest
    override type B = ListTablesResult
    override val handler = listTablesU
    override val marshaller = listTablesM
    def toOp: ListTables = this
  }

  implicit class DescribeTimeToLive(val request: DescribeTimeToLiveRequest) extends AwsOp {
    override type A = DescribeTimeToLiveRequest
    override type B = DescribeTimeToLiveResult
    override val handler = describeTimeToLiveU
    override val marshaller = describeTimeToLiveM
    def toOp: DescribeTimeToLive = this
  }

  implicit class UpdateTimeToLive(val request: UpdateTimeToLiveRequest) extends AwsOp {
    override type A = UpdateTimeToLiveRequest
    override type B = UpdateTimeToLiveResult
    override val handler = updateTimeToLiveU
    override val marshaller = updateTimeToLiveM
    def toOp: UpdateTimeToLive = this
  }
}
