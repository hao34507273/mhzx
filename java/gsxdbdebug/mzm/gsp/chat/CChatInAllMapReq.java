/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PChatInAllMap;
/*    */ 
/*    */ 
/*    */ public class CChatInAllMapReq
/*    */   extends __CChatInAllMapReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585266;
/*    */   public int map_cfg_id;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L)
/*    */     {
/* 23 */       return;
/*    */     }
/* 25 */     Role.addRoleProcedure(roleId, new PChatInAllMap(roleId, this.map_cfg_id, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 33 */     return 12585266;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CChatInAllMapReq()
/*    */   {
/* 41 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInAllMapReq(int _map_cfg_id_, int _contenttype_, Octets _content_) {
/* 45 */     this.map_cfg_id = _map_cfg_id_;
/* 46 */     this.contenttype = _contenttype_;
/* 47 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 51 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 55 */     _os_.marshal(this.map_cfg_id);
/* 56 */     _os_.marshal(this.contenttype);
/* 57 */     _os_.marshal(this.content);
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 62 */     this.map_cfg_id = _os_.unmarshal_int();
/* 63 */     this.contenttype = _os_.unmarshal_int();
/* 64 */     this.content = _os_.unmarshal_Octets();
/* 65 */     if (!_validator_()) {
/* 66 */       throw new VerifyError("validator failed");
/*    */     }
/* 68 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 72 */     if (_o1_ == this) return true;
/* 73 */     if ((_o1_ instanceof CChatInAllMapReq)) {
/* 74 */       CChatInAllMapReq _o_ = (CChatInAllMapReq)_o1_;
/* 75 */       if (this.map_cfg_id != _o_.map_cfg_id) return false;
/* 76 */       if (this.contenttype != _o_.contenttype) return false;
/* 77 */       if (!this.content.equals(_o_.content)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.map_cfg_id;
/* 86 */     _h_ += this.contenttype;
/* 87 */     _h_ += this.content.hashCode();
/* 88 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 92 */     StringBuilder _sb_ = new StringBuilder();
/* 93 */     _sb_.append("(");
/* 94 */     _sb_.append(this.map_cfg_id).append(",");
/* 95 */     _sb_.append(this.contenttype).append(",");
/* 96 */     _sb_.append("B").append(this.content.size()).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInAllMapReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */