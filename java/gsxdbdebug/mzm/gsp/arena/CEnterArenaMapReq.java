/*    */ package mzm.gsp.arena;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.arena.main.PEnterArenaMapReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CEnterArenaMapReq
/*    */   extends __CEnterArenaMapReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596740;
/*    */   public int npc;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     Role.addRoleProcedure(roleid, new PEnterArenaMapReq(roleid, this.npc));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12596740;
/*    */   }
/*    */   
/*    */ 
/*    */   public CEnterArenaMapReq() {}
/*    */   
/*    */ 
/*    */   public CEnterArenaMapReq(int _npc_)
/*    */   {
/* 37 */     this.npc = _npc_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.npc);
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 50 */     this.npc = _os_.unmarshal_int();
/* 51 */     if (!_validator_()) {
/* 52 */       throw new VerifyError("validator failed");
/*    */     }
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 58 */     if (_o1_ == this) return true;
/* 59 */     if ((_o1_ instanceof CEnterArenaMapReq)) {
/* 60 */       CEnterArenaMapReq _o_ = (CEnterArenaMapReq)_o1_;
/* 61 */       if (this.npc != _o_.npc) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.npc;
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.npc).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CEnterArenaMapReq _o_) {
/* 82 */     if (_o_ == this) return 0;
/* 83 */     int _c_ = 0;
/* 84 */     _c_ = this.npc - _o_.npc;
/* 85 */     if (0 != _c_) return _c_;
/* 86 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\CEnterArenaMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */