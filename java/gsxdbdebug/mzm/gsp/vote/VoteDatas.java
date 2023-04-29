/*    */ package mzm.gsp.vote;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class VoteDatas implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public ArrayList<VoteData> votedinfos;
/*    */   
/*    */   public VoteDatas()
/*    */   {
/* 12 */     this.votedinfos = new ArrayList();
/*    */   }
/*    */   
/*    */   public VoteDatas(ArrayList<VoteData> _votedinfos_) {
/* 16 */     this.votedinfos = _votedinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 20 */     for (VoteData _v_ : this.votedinfos)
/* 21 */       if (!_v_._validator_()) return false;
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.compact_uint32(this.votedinfos.size());
/* 27 */     for (VoteData _v_ : this.votedinfos) {
/* 28 */       _os_.marshal(_v_);
/*    */     }
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 34 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 35 */       VoteData _v_ = new VoteData();
/* 36 */       _v_.unmarshal(_os_);
/* 37 */       this.votedinfos.add(_v_);
/*    */     }
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof VoteDatas)) {
/* 45 */       VoteDatas _o_ = (VoteDatas)_o1_;
/* 46 */       if (!this.votedinfos.equals(_o_.votedinfos)) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += this.votedinfos.hashCode();
/* 55 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 59 */     StringBuilder _sb_ = new StringBuilder();
/* 60 */     _sb_.append("(");
/* 61 */     _sb_.append(this.votedinfos).append(",");
/* 62 */     _sb_.append(")");
/* 63 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\VoteDatas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */