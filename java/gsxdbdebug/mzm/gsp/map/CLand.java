/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.PLand;
/*    */ 
/*    */ 
/*    */ public class CLand
/*    */   extends __CLand__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590905;
/*    */   public Location pos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleid = Role.getRoleId(this);
/* 18 */     Role.addRoleProcedure(roleid, new PLand(roleid, this.pos.x, this.pos.y));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 26 */     return 12590905;
/*    */   }
/*    */   
/*    */ 
/*    */   public CLand()
/*    */   {
/* 32 */     this.pos = new Location();
/*    */   }
/*    */   
/*    */   public CLand(Location _pos_) {
/* 36 */     this.pos = _pos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 40 */     if (!this.pos._validator_()) return false;
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.pos);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.pos.unmarshal(_os_);
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CLand)) {
/* 60 */       CLand _o_ = (CLand)_o1_;
/* 61 */       if (!this.pos.equals(_o_.pos)) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.pos.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.pos).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CLand _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.pos.compareTo(_o_.pos);
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CLand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */