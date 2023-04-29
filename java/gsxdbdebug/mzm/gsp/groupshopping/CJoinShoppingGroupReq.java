/*     */ package mzm.gsp.groupshopping;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.groupshopping.main.GroupShoppingTaskManager;
/*     */ import mzm.gsp.groupshopping.main.PJoinShoppingGroup;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ 
/*     */ public class CJoinShoppingGroupReq
/*     */   extends __CJoinShoppingGroupReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12623619;
/*     */   public long group_id;
/*     */   public long current_yuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     boolean r = GroupShoppingTaskManager.addTask(new PJoinShoppingGroup(roleId, this.group_id, this.current_yuanbao));
/*     */     
/*  22 */     if (!r)
/*     */     {
/*  24 */       SJoinShoppingGroupFail fail = new SJoinShoppingGroupFail();
/*  25 */       fail.group_id = this.group_id;
/*  26 */       fail.reason = 5;
/*  27 */       OnlineManager.getInstance().send(roleId, fail);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12623619;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CJoinShoppingGroupReq() {}
/*     */   
/*     */ 
/*     */   public CJoinShoppingGroupReq(long _group_id_, long _current_yuanbao_)
/*     */   {
/*  46 */     this.group_id = _group_id_;
/*  47 */     this.current_yuanbao = _current_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.group_id);
/*  56 */     _os_.marshal(this.current_yuanbao);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.group_id = _os_.unmarshal_long();
/*  62 */     this.current_yuanbao = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CJoinShoppingGroupReq)) {
/*  72 */       CJoinShoppingGroupReq _o_ = (CJoinShoppingGroupReq)_o1_;
/*  73 */       if (this.group_id != _o_.group_id) return false;
/*  74 */       if (this.current_yuanbao != _o_.current_yuanbao) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += (int)this.group_id;
/*  83 */     _h_ += (int)this.current_yuanbao;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.group_id).append(",");
/*  91 */     _sb_.append(this.current_yuanbao).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CJoinShoppingGroupReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = Long.signum(this.group_id - _o_.group_id);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.current_yuanbao - _o_.current_yuanbao);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\groupshopping\CJoinShoppingGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */