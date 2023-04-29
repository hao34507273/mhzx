/*    */ package mzm.gsp.loginaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class LoginSumActivityInfo implements Marshal
/*    */ {
/*    */   public int logindays;
/*    */   public ArrayList<Integer> sortids;
/*    */   
/*    */   public LoginSumActivityInfo()
/*    */   {
/* 15 */     this.sortids = new ArrayList();
/*    */   }
/*    */   
/*    */   public LoginSumActivityInfo(int _logindays_, ArrayList<Integer> _sortids_) {
/* 19 */     this.logindays = _logindays_;
/* 20 */     this.sortids = _sortids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.logindays);
/* 29 */     _os_.compact_uint32(this.sortids.size());
/* 30 */     for (Integer _v_ : this.sortids) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.logindays = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.sortids.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof LoginSumActivityInfo)) {
/* 49 */       LoginSumActivityInfo _o_ = (LoginSumActivityInfo)_o1_;
/* 50 */       if (this.logindays != _o_.logindays) return false;
/* 51 */       if (!this.sortids.equals(_o_.sortids)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.logindays;
/* 60 */     _h_ += this.sortids.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.logindays).append(",");
/* 68 */     _sb_.append(this.sortids).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\LoginSumActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */