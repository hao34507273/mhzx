/*    */ package mzm.gsp.menpaipvp;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class Champion
/*    */   implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int menpai;
/*    */   
/*    */   public Champion()
/*    */   {
/* 16 */     this.name = "";
/*    */   }
/*    */   
/*    */   public Champion(long _roleid_, String _name_, int _menpai_) {
/* 20 */     this.roleid = _roleid_;
/* 21 */     this.name = _name_;
/* 22 */     this.menpai = _menpai_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.roleid);
/* 31 */     _os_.marshal(this.name, "UTF-16LE");
/* 32 */     _os_.marshal(this.menpai);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.roleid = _os_.unmarshal_long();
/* 38 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 39 */     this.menpai = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof Champion)) {
/* 46 */       Champion _o_ = (Champion)_o1_;
/* 47 */       if (this.roleid != _o_.roleid) return false;
/* 48 */       if (!this.name.equals(_o_.name)) return false;
/* 49 */       if (this.menpai != _o_.menpai) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += (int)this.roleid;
/* 58 */     _h_ += this.name.hashCode();
/* 59 */     _h_ += this.menpai;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.roleid).append(",");
/* 67 */     _sb_.append("T").append(this.name.length()).append(",");
/* 68 */     _sb_.append(this.menpai).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaipvp\Champion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */