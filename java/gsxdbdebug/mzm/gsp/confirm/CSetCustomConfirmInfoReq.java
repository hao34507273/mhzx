/*    */ package mzm.gsp.confirm;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.confirm.main.PCSetCustomConfirmInfoReq;
/*    */ 
/*    */ 
/*    */ public class CSetCustomConfirmInfoReq
/*    */   extends __CSetCustomConfirmInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617989;
/*    */   public HashMap<Integer, Integer> confirminfos;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PCSetCustomConfirmInfoReq(roleId, this.confirminfos));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12617989;
/*    */   }
/*    */   
/*    */ 
/*    */   public CSetCustomConfirmInfoReq()
/*    */   {
/* 38 */     this.confirminfos = new HashMap();
/*    */   }
/*    */   
/*    */   public CSetCustomConfirmInfoReq(HashMap<Integer, Integer> _confirminfos_) {
/* 42 */     this.confirminfos = _confirminfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.compact_uint32(this.confirminfos.size());
/* 51 */     for (Map.Entry<Integer, Integer> _e_ : this.confirminfos.entrySet()) {
/* 52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 61 */       int _k_ = _os_.unmarshal_int();
/*    */       
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.confirminfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CSetCustomConfirmInfoReq)) {
/* 75 */       CSetCustomConfirmInfoReq _o_ = (CSetCustomConfirmInfoReq)_o1_;
/* 76 */       if (!this.confirminfos.equals(_o_.confirminfos)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += this.confirminfos.hashCode();
/* 85 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuilder _sb_ = new StringBuilder();
/* 90 */     _sb_.append("(");
/* 91 */     _sb_.append(this.confirminfos).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\confirm\CSetCustomConfirmInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */