/*    */ package mzm.gsp.instance;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SBrocastTeamInstanceItem
/*    */   extends __SBrocastTeamInstanceItem__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591388;
/*    */   public Octets role_name;
/*    */   public int instance_cfg_id;
/*    */   public int item_cfg_id;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591388;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SBrocastTeamInstanceItem()
/*    */   {
/* 35 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public SBrocastTeamInstanceItem(Octets _role_name_, int _instance_cfg_id_, int _item_cfg_id_) {
/* 39 */     this.role_name = _role_name_;
/* 40 */     this.instance_cfg_id = _instance_cfg_id_;
/* 41 */     this.item_cfg_id = _item_cfg_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.role_name);
/* 50 */     _os_.marshal(this.instance_cfg_id);
/* 51 */     _os_.marshal(this.item_cfg_id);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.role_name = _os_.unmarshal_Octets();
/* 57 */     this.instance_cfg_id = _os_.unmarshal_int();
/* 58 */     this.item_cfg_id = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SBrocastTeamInstanceItem)) {
/* 68 */       SBrocastTeamInstanceItem _o_ = (SBrocastTeamInstanceItem)_o1_;
/* 69 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 70 */       if (this.instance_cfg_id != _o_.instance_cfg_id) return false;
/* 71 */       if (this.item_cfg_id != _o_.item_cfg_id) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.role_name.hashCode();
/* 80 */     _h_ += this.instance_cfg_id;
/* 81 */     _h_ += this.item_cfg_id;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 89 */     _sb_.append(this.instance_cfg_id).append(",");
/* 90 */     _sb_.append(this.item_cfg_id).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\SBrocastTeamInstanceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */