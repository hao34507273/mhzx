/*    */ package mzm.gsp.paraselene;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.paraselene.main.PStartLayerTask;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CStartLayerTask
/*    */   extends __CStartLayerTask__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12598277;
/*    */   public int npc;
/*    */   public int npcservice;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleId, new PStartLayerTask(roleId, this.npc, this.npcservice));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12598277;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CStartLayerTask() {}
/*    */   
/*    */ 
/*    */   public CStartLayerTask(int _npc_, int _npcservice_)
/*    */   {
/* 40 */     this.npc = _npc_;
/* 41 */     this.npcservice = _npcservice_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.npc);
/* 50 */     _os_.marshal(this.npcservice);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.npc = _os_.unmarshal_int();
/* 56 */     this.npcservice = _os_.unmarshal_int();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CStartLayerTask)) {
/* 66 */       CStartLayerTask _o_ = (CStartLayerTask)_o1_;
/* 67 */       if (this.npc != _o_.npc) return false;
/* 68 */       if (this.npcservice != _o_.npcservice) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.npc;
/* 77 */     _h_ += this.npcservice;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.npc).append(",");
/* 85 */     _sb_.append(this.npcservice).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CStartLayerTask _o_) {
/* 91 */     if (_o_ == this) return 0;
/* 92 */     int _c_ = 0;
/* 93 */     _c_ = this.npc - _o_.npc;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = this.npcservice - _o_.npcservice;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\CStartLayerTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */