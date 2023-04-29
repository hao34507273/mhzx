/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class CrossCompeteTeamBackReq implements Marshal
/*    */ {
/*    */   public ArrayList<CrossCompeteUserDataBack> users;
/*    */   
/*    */   public CrossCompeteTeamBackReq()
/*    */   {
/* 14 */     this.users = new ArrayList();
/*    */   }
/*    */   
/*    */   public CrossCompeteTeamBackReq(ArrayList<CrossCompeteUserDataBack> _users_) {
/* 18 */     this.users = _users_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     for (CrossCompeteUserDataBack _v_ : this.users)
/* 23 */       if (!_v_._validator_()) return false;
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.compact_uint32(this.users.size());
/* 29 */     for (CrossCompeteUserDataBack _v_ : this.users) {
/* 30 */       _os_.marshal(_v_);
/*    */     }
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 37 */       CrossCompeteUserDataBack _v_ = new CrossCompeteUserDataBack();
/* 38 */       _v_.unmarshal(_os_);
/* 39 */       this.users.add(_v_);
/*    */     }
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof CrossCompeteTeamBackReq)) {
/* 47 */       CrossCompeteTeamBackReq _o_ = (CrossCompeteTeamBackReq)_o1_;
/* 48 */       if (!this.users.equals(_o_.users)) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += this.users.hashCode();
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.users).append(",");
/* 64 */     _sb_.append(")");
/* 65 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteTeamBackReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */