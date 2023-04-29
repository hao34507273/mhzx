/*    */ package mzm.gsp.masswedding;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class SignUpInfo implements Marshal
/*    */ {
/*    */   public long roleid1;
/*    */   public String rolename1;
/*    */   public long roleid2;
/*    */   public String rolename2;
/*    */   public int price;
/*    */   
/*    */   public SignUpInfo()
/*    */   {
/* 16 */     this.rolename1 = "";
/* 17 */     this.rolename2 = "";
/*    */   }
/*    */   
/*    */   public SignUpInfo(long _roleid1_, String _rolename1_, long _roleid2_, String _rolename2_, int _price_) {
/* 21 */     this.roleid1 = _roleid1_;
/* 22 */     this.rolename1 = _rolename1_;
/* 23 */     this.roleid2 = _roleid2_;
/* 24 */     this.rolename2 = _rolename2_;
/* 25 */     this.price = _price_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.roleid1);
/* 34 */     _os_.marshal(this.rolename1, "UTF-16LE");
/* 35 */     _os_.marshal(this.roleid2);
/* 36 */     _os_.marshal(this.rolename2, "UTF-16LE");
/* 37 */     _os_.marshal(this.price);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 42 */     this.roleid1 = _os_.unmarshal_long();
/* 43 */     this.rolename1 = _os_.unmarshal_String("UTF-16LE");
/* 44 */     this.roleid2 = _os_.unmarshal_long();
/* 45 */     this.rolename2 = _os_.unmarshal_String("UTF-16LE");
/* 46 */     this.price = _os_.unmarshal_int();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof SignUpInfo)) {
/* 53 */       SignUpInfo _o_ = (SignUpInfo)_o1_;
/* 54 */       if (this.roleid1 != _o_.roleid1) return false;
/* 55 */       if (!this.rolename1.equals(_o_.rolename1)) return false;
/* 56 */       if (this.roleid2 != _o_.roleid2) return false;
/* 57 */       if (!this.rolename2.equals(_o_.rolename2)) return false;
/* 58 */       if (this.price != _o_.price) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.roleid1;
/* 67 */     _h_ += this.rolename1.hashCode();
/* 68 */     _h_ += (int)this.roleid2;
/* 69 */     _h_ += this.rolename2.hashCode();
/* 70 */     _h_ += this.price;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.roleid1).append(",");
/* 78 */     _sb_.append("T").append(this.rolename1.length()).append(",");
/* 79 */     _sb_.append(this.roleid2).append(",");
/* 80 */     _sb_.append("T").append(this.rolename2.length()).append(",");
/* 81 */     _sb_.append(this.price).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SignUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */