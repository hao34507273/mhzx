/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.map.main.PCMapItemGather;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CMapItemGather
/*    */   extends __CMapItemGather__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590858;
/*    */   public int instanceid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCMapItemGather(roleid, this.instanceid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12590858;
/*    */   }
/*    */   
/*    */ 
/*    */   public CMapItemGather() {}
/*    */   
/*    */ 
/*    */   public CMapItemGather(int _instanceid_)
/*    */   {
/* 41 */     this.instanceid = _instanceid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.instanceid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.instanceid = _os_.unmarshal_int();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CMapItemGather)) {
/* 64 */       CMapItemGather _o_ = (CMapItemGather)_o1_;
/* 65 */       if (this.instanceid != _o_.instanceid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.instanceid;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.instanceid).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CMapItemGather _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.instanceid - _o_.instanceid;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\CMapItemGather.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */