package tools.udg;

import java.util.LinkedList;
import java.util.List;

import misc.Pair;

import org.neo4j.unsafe.batchinsert.BatchRelationship;

import traversals.batchInserter.AST;
import traversals.batchInserter.Elementary;

public class BatchInserterDBProvider extends DBProvider
{

	public String getNodeType(Long nodeId)
	{
		return Elementary.getNodeType(nodeId);
	}

	public String getCalleeFromCall(Long nodeId)
	{
		return AST.getCalleeFromCall(nodeId);
	}

	public List<Pair<Long,Integer>> getASTChildren(Long nodeId)
	{
		Iterable<BatchRelationship> rels = Elementary.getEdges(nodeId);
		List<Pair<Long, Integer>> retval = new LinkedList<Pair<Long, Integer>>();
		
		for(BatchRelationship rel : rels){
			if(Elementary.isIncomingEdge(nodeId, rel)) continue;
			if(!AST.isASTEdge(rel)) continue;
		
			long childId = rel.getEndNode();
			Integer childNumber = Integer.parseInt(Elementary.getChildNumber(rel));
			retval.add(new Pair<Long,Integer>(childId, childNumber));
		}
		return retval;
	}

	@Override
	public String getNodeCode(long nodeId)
	{
		return Elementary.getNodeCode(nodeId);
	}

	@Override
	public String getOperatorCode(long nodeId)
	{
		return Elementary.getOperatorCode(nodeId);
	}
}
