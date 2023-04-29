/*    */ package mzm.gsp.vote;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.vote.main.PCCommonVoteReq;
/*    */ 
/*    */ 
/*    */ public class CCommonVoteReq
/*    */   extends __CCommonVoteReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611844;
/*    */   public int activityid;
/*    */   public HashSet<Integer> voteids;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PCCommonVoteReq(roleid, this.activityid, this.voteids));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12611844;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CCommonVoteReq()
/*    */   {
/* 38 */     this.voteids = new HashSet();
/*    */   }
/*    */   
/*    */   public CCommonVoteReq(int _activityid_, HashSet<Integer> _voteids_) {
/* 42 */     this.activityid = _activityid_;
/* 43 */     this.voteids = _voteids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.activityid);
/* 52 */     _os_.compact_uint32(this.voteids.size());
/* 53 */     for (Integer _v_ : this.voteids) {
/* 54 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.activityid = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.voteids.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CCommonVoteReq)) {
/* 75 */       CCommonVoteReq _o_ = (CCommonVoteReq)_o1_;
/* 76 */       if (this.activityid != _o_.activityid) return false;
/* 77 */       if (!this.voteids.equals(_o_.voteids)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.activityid;
/* 86 */     _h_ += this.voteids.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.activityid).append(",");
/* 94 */     _sb_.append(this.voteids).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\CCommonVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */