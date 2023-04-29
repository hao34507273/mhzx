/*    */ package mzm.gsp.vote;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashSet;
/*    */ 
/*    */ public class VoteData implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public HashSet<Integer> votedids;
/*    */   
/*    */   public VoteData()
/*    */   {
/* 12 */     this.votedids = new HashSet();
/*    */   }
/*    */   
/*    */   public VoteData(HashSet<Integer> _votedids_) {
/* 16 */     this.votedids = _votedids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 24 */     _os_.compact_uint32(this.votedids.size());
/* 25 */     for (Integer _v_ : this.votedids) {
/* 26 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 34 */       int _v_ = _os_.unmarshal_int();
/* 35 */       this.votedids.add(Integer.valueOf(_v_));
/*    */     }
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof VoteData)) {
/* 43 */       VoteData _o_ = (VoteData)_o1_;
/* 44 */       if (!this.votedids.equals(_o_.votedids)) return false;
/* 45 */       return true;
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 51 */     int _h_ = 0;
/* 52 */     _h_ += this.votedids.hashCode();
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.votedids).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\VoteData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */