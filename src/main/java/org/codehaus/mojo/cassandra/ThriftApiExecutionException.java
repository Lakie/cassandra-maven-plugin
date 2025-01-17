package org.codehaus.mojo.cassandra;

import org.apache.thrift.TException;
import org.cassandraunit.shaded.org.apache.cassandra.thrift.InvalidRequestException;
import org.cassandraunit.shaded.org.apache.cassandra.thrift.SchemaDisagreementException;
import org.cassandraunit.shaded.org.apache.cassandra.thrift.TimedOutException;
import org.cassandraunit.shaded.org.apache.cassandra.thrift.UnavailableException;

/**
 * Exception to wrap the various Exceptions that can come back 
 * from Apache Cassandra's Trift API
 * 
 * @author zznate
 */
public class ThriftApiExecutionException extends RuntimeException
{

    private static final long serialVersionUID = 5653554393371671913L;

    private static final String ERR_MSG = "There was a problem calling Apache Cassandra's Thrift API. ";

    public ThriftApiExecutionException()
    {
        super(ERR_MSG);
    }
    
    public ThriftApiExecutionException(String msg)
    {
        super(ERR_MSG + msg);
    }
    
    public ThriftApiExecutionException(Throwable t)
    {
        super(ERR_MSG + deduceExceptionMessage(t), t);
    }
    
    
    private static String deduceExceptionMessage(Throwable t)
    {
        StringBuilder msg = new StringBuilder("Details: ");
        if ( t instanceof UnavailableException)
            msg.append("You do not have enough nodes up to handle the specified consistency level");
        else if ( t instanceof TimedOutException)
            msg.append("Request timed out - server load may be too high, or you may be requesting too many rows for a single operation");
        else if ( t instanceof InvalidRequestException)
            msg.append("The request was not properly formatted ").append(((InvalidRequestException) t).getWhy());
        else if ( t instanceof SchemaDisagreementException)
            msg.append("Schema versions are out of sync");
        else if ( t instanceof TException )
            msg.append("General Thrift Exception, ensure Apache Cassandra is running and all necessary ports are accessible");
        else
            msg.append("n/a");
        return msg.toString();
    }
}
