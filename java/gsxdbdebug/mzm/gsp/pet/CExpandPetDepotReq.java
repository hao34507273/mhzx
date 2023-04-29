/*    */ package mzm.gsp.pet;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.pet.main.PExpandDepot;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CExpandPetDepotReq
/*    */   extends __CExpandPetDepotReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590625;
/*    */   public int itemnum;
/*    */   public long yuanbaonum;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PExpandDepot(roleId, this.itemnum, this.yuanbaonum));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12590625;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CExpandPetDepotReq() {}
/*    */   
/*    */ 
/*    */   public CExpandPetDepotReq(int _itemnum_, long _yuanbaonum_)
/*    */   {
/* 41 */     this.itemnum = _itemnum_;
/* 42 */     this.yuanbaonum = _yuanbaonum_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.itemnum);
/* 51 */     _os_.marshal(this.yuanbaonum);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.itemnum = _os_.unmarshal_int();
/* 57 */     this.yuanbaonum = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CExpandPetDepotReq)) {
/* 67 */       CExpandPetDepotReq _o_ = (CExpandPetDepotReq)_o1_;
/* 68 */       if (this.itemnum != _o_.itemnum) return false;
/* 69 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.itemnum;
/* 78 */     _h_ += (int)this.yuanbaonum;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.itemnum).append(",");
/* 86 */     _sb_.append(this.yuanbaonum).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CExpandPetDepotReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.itemnum - _o_.itemnum;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CExpandPetDepotReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */