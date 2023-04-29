/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.item.main.PCBuyGoldIngotReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CBuyGoldIngotReq
/*    */   extends __CBuyGoldIngotReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584839;
/*    */   public int yuanbao_num;
/*    */   public long client_yuanbao;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid == -1L)
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleid, new PCBuyGoldIngotReq(roleid, this.yuanbao_num, this.client_yuanbao));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12584839;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CBuyGoldIngotReq() {}
/*    */   
/*    */ 
/*    */   public CBuyGoldIngotReq(int _yuanbao_num_, long _client_yuanbao_)
/*    */   {
/* 42 */     this.yuanbao_num = _yuanbao_num_;
/* 43 */     this.client_yuanbao = _client_yuanbao_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.yuanbao_num);
/* 52 */     _os_.marshal(this.client_yuanbao);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.yuanbao_num = _os_.unmarshal_int();
/* 58 */     this.client_yuanbao = _os_.unmarshal_long();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CBuyGoldIngotReq)) {
/* 68 */       CBuyGoldIngotReq _o_ = (CBuyGoldIngotReq)_o1_;
/* 69 */       if (this.yuanbao_num != _o_.yuanbao_num) return false;
/* 70 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.yuanbao_num;
/* 79 */     _h_ += (int)this.client_yuanbao;
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.yuanbao_num).append(",");
/* 87 */     _sb_.append(this.client_yuanbao).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CBuyGoldIngotReq _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     _c_ = this.yuanbao_num - _o_.yuanbao_num;
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = Long.signum(this.client_yuanbao - _o_.client_yuanbao);
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CBuyGoldIngotReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */