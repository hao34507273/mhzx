/*    */ package mzm.gsp.vote;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SCommonVoteSuc
/*    */   extends __SCommonVoteSuc__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12611842;
/*    */   public int activityid;
/*    */   public HashSet<Integer> voteids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12611842;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SCommonVoteSuc()
/*    */   {
/* 34 */     this.voteids = new HashSet();
/*    */   }
/*    */   
/*    */   public SCommonVoteSuc(int _activityid_, HashSet<Integer> _voteids_) {
/* 38 */     this.activityid = _activityid_;
/* 39 */     this.voteids = _voteids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.activityid);
/* 48 */     _os_.compact_uint32(this.voteids.size());
/* 49 */     for (Integer _v_ : this.voteids) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.voteids.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SCommonVoteSuc)) {
/* 71 */       SCommonVoteSuc _o_ = (SCommonVoteSuc)_o1_;
/* 72 */       if (this.activityid != _o_.activityid) return false;
/* 73 */       if (!this.voteids.equals(_o_.voteids)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.activityid;
/* 82 */     _h_ += this.voteids.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.activityid).append(",");
/* 90 */     _sb_.append(this.voteids).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\SCommonVoteSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */