package spatialfunction;

import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.phoenix.compile.KeyPart;
import org.apache.phoenix.expression.function.ScalarFunction;
import org.apache.phoenix.schema.tuple.Tuple;
import org.apache.phoenix.schema.types.PDataType;

/**
 * 文件描述：
 * 作者： bamboo
 * 时间： 2016/12/27
 */
public class AsTextFunction extends ScalarFunction {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean evaluate(Tuple tuple, ImmutableBytesWritable immutableBytesWritable) {
        return false;
    }

    @Override
    public PDataType getDataType() {
        return null;
    }

    @Override
    public int getKeyFormationTraversalIndex() {
        return super.getKeyFormationTraversalIndex();
    }

    @Override
    public KeyPart newKeyPart(KeyPart childPart) {
        return super.newKeyPart(childPart);
    }
}
