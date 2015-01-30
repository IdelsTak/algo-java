package t04_Tree_Graph;

import org.junit.Test;

public class E7_CommonAncestor {
	/*
	Solution 1: with link to parents: easy
	*/
	
	/*
	Solution 2: dont use any additional structure
	*/
	
	boolean Cover(Td r, Td n){
		if(r == null) return false;
		if(r == n) return true;
		return Cover(r.left, n) || Cover(r.right, n);
	}
	
	boolean CoverBoth(Td r, Td p, Td q){
		return Cover(r, p) && Cover(r,q);
	}
	
	Td commonAncestor_2_1(Td r, Td p, Td q){
		if(CoverBoth(r.left, p, q)) 
			return commonAncestor_2_1(r.left, p, q);
		if(CoverBoth(r.right, p, q)) 
			return commonAncestor_2_1(r.right, p, q);
		if(CoverBoth(r, p, q)) return r;
		return null;
	}
	/*
	Solution 2: Book
	*/
	Td commonAncestor_2_2(Td r, Td p, Td q){	
		//error check
		if(!Cover(r, p) && !Cover(r, q)) return null;
		return commonAncestorHelper(r, p, q);
	}

	private Td commonAncestorHelper(Td r, Td p, Td q) {
		if(r == p || r == q) return r;
		boolean isPLeft = Cover(r,p);
		boolean isQLeft = Cover(r,q);
		if(isPLeft != isQLeft) return r;
		
		Td side = isPLeft ? r.left : r.right;
		return commonAncestorHelper(side, p, q);
	}
	
	/*
	Solution 3: my Method
	*/
	class WrapResult_my{
		boolean pCovered;
		boolean qCovered;
		void setP(){pCovered = true;};
		void setQ(){qCovered = true;};
		boolean bothCovered(){
			return qCovered && qCovered;
		}//
		Td node = null;
	}
	
	Td commonAncestor_3_my(Td r, Td p, Td q){
		return commonAncestorHelper_2_my(r, p, q, new WrapResult_my());
	}
	
	Td commonAncestorHelper_2_my(Td r, Td p, Td q, WrapResult_my w){
		if (r == null) return null;
		if (w.bothCovered()) return w.node;
		commonAncestorHelper_2_my(r.left, p, q, w);
		commonAncestorHelper_2_my(r.right, p, q, w);
		if(r == p) w.setP();
		if(r == q) w.setQ();
		if(w.bothCovered()) w.node = r;
		return w.node;
	}

	/*
	Solution 3: book Method
	*/
	class Result{
		boolean isAncestor;
		Td node;
		Result(Td n, boolean isA){
			this.isAncestor = isA;
			this.node = n;
		}
	}
	
	Result commonAncestor_bk(Td r, Td p, Td q){
		if(r == null) return new Result(null, false);
		if(r==p && r==q) return new Result(r, true);
		
		Result tx = commonAncestor_bk(r.left, p, q);
		if(tx.isAncestor) return tx;
		
		Result ty = commonAncestor_bk(r.right, p, q);
		if(ty.isAncestor) return ty;

		if(tx.node != null && ty.node != null) return new Result(r, true);
		else if( (r == p && (ty.node == q || tx.node == q)) ||
			(r == q && (ty.node == p || tx.node == p)) )
			return new Result(r, true);
		else
			return tx.node != null ? tx : ty;
	}
	
	
	@Test
	public void test(){
		
	}
}
