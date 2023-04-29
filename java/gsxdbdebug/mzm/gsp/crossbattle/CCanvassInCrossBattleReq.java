/*    */ package mzm.gsp.crossbattle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.crossbattle.main.CrossBattleOneByOneManager;
/*    */ import mzm.gsp.crossbattle.own.PCCanvassInCrossBattle;
/*    */ 
/*    */ public class CCanvassInCrossBattleReq extends __CCanvassInCrossBattleReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12616968;
/*    */   public int activity_cfg_id;
/*    */   public long target_corps_id;
/*    */   public Octets text;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     if ((roleid < 0L) || (!mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg.getAll().containsKey(Integer.valueOf(this.activity_cfg_id))))
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     CrossBattleOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activity_cfg_id), new PCCanvassInCrossBattle(roleid, this.activity_cfg_id, this.target_corps_id, this.text));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 34 */     return 12616968;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CCanvassInCrossBattleReq()
/*    */   {
/* 42 */     this.text = new Octets();
/*    */   }
/*    */   
/*    */   public CCanvassInCrossBattleReq(int _activity_cfg_id_, long _target_corps_id_, Octets _text_) {
/* 46 */     this.activity_cfg_id = _activity_cfg_id_;
/* 47 */     this.target_corps_id = _target_corps_id_;
/* 48 */     this.text = _text_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 52 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 56 */     _os_.marshal(this.activity_cfg_id);
/* 57 */     _os_.marshal(this.target_corps_id);
/* 58 */     _os_.marshal(this.text);
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.activity_cfg_id = _os_.unmarshal_int();
/* 64 */     this.target_corps_id = _os_.unmarshal_long();
/* 65 */     this.text = _os_.unmarshal_Octets();
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CCanvassInCrossBattleReq)) {
/* 75 */       CCanvassInCrossBattleReq _o_ = (CCanvassInCrossBattleReq)_o1_;
/* 76 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 77 */       if (this.target_corps_id != _o_.target_corps_id) return false;
/* 78 */       if (!this.text.equals(_o_.text)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.activity_cfg_id;
/* 87 */     _h_ += (int)this.target_corps_id;
/* 88 */     _h_ += this.text.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.activity_cfg_id).append(",");
/* 96 */     _sb_.append(this.target_corps_id).append(",");
/* 97 */     _sb_.append("B").append(this.text.size()).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CCanvassInCrossBattleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */