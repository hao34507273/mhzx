/*    */ package mzm.gsp.loginaward;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class LoginActivityInfo implements Marshal
/*    */ {
/*    */   public int currentday;
/*    */   public ArrayList<Integer> sortids;
/*    */   public int misssortids;
/*    */   
/*    */   public LoginActivityInfo()
/*    */   {
/* 16 */     this.sortids = new ArrayList();
/*    */   }
/*    */   
/*    */   public LoginActivityInfo(int _currentday_, ArrayList<Integer> _sortids_, int _misssortids_) {
/* 20 */     this.currentday = _currentday_;
/* 21 */     this.sortids = _sortids_;
/* 22 */     this.misssortids = _misssortids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.currentday);
/* 31 */     _os_.compact_uint32(this.sortids.size());
/* 32 */     for (Integer _v_ : this.sortids) {
/* 33 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 35 */     _os_.marshal(this.misssortids);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.currentday = _os_.unmarshal_int();
/* 41 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 43 */       int _v_ = _os_.unmarshal_int();
/* 44 */       this.sortids.add(Integer.valueOf(_v_));
/*    */     }
/* 46 */     this.misssortids = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof LoginActivityInfo)) {
/* 53 */       LoginActivityInfo _o_ = (LoginActivityInfo)_o1_;
/* 54 */       if (this.currentday != _o_.currentday) return false;
/* 55 */       if (!this.sortids.equals(_o_.sortids)) return false;
/* 56 */       if (this.misssortids != _o_.misssortids) return false;
/* 57 */       return true;
/*    */     }
/* 59 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 63 */     int _h_ = 0;
/* 64 */     _h_ += this.currentday;
/* 65 */     _h_ += this.sortids.hashCode();
/* 66 */     _h_ += this.misssortids;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.currentday).append(",");
/* 74 */     _sb_.append(this.sortids).append(",");
/* 75 */     _sb_.append(this.misssortids).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\loginaward\LoginActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */