/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PGiveFlower;
/*     */ 
/*     */ 
/*     */ public class CGiveFlowerReq
/*     */   extends __CGiveFlowerReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584793;
/*     */   public long receiverroleid;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   public String message;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long selfRoleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(selfRoleid, new PGiveFlower(selfRoleid, this.receiverroleid, this.itemid, this.itemnum, this.message));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12584793;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CGiveFlowerReq()
/*     */   {
/*  39 */     this.message = "";
/*     */   }
/*     */   
/*     */   public CGiveFlowerReq(long _receiverroleid_, int _itemid_, int _itemnum_, String _message_) {
/*  43 */     this.receiverroleid = _receiverroleid_;
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.itemnum = _itemnum_;
/*  46 */     this.message = _message_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.receiverroleid);
/*  55 */     _os_.marshal(this.itemid);
/*  56 */     _os_.marshal(this.itemnum);
/*  57 */     _os_.marshal(this.message, "UTF-16LE");
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.receiverroleid = _os_.unmarshal_long();
/*  63 */     this.itemid = _os_.unmarshal_int();
/*  64 */     this.itemnum = _os_.unmarshal_int();
/*  65 */     this.message = _os_.unmarshal_String("UTF-16LE");
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CGiveFlowerReq)) {
/*  75 */       CGiveFlowerReq _o_ = (CGiveFlowerReq)_o1_;
/*  76 */       if (this.receiverroleid != _o_.receiverroleid) return false;
/*  77 */       if (this.itemid != _o_.itemid) return false;
/*  78 */       if (this.itemnum != _o_.itemnum) return false;
/*  79 */       if (!this.message.equals(_o_.message)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.receiverroleid;
/*  88 */     _h_ += this.itemid;
/*  89 */     _h_ += this.itemnum;
/*  90 */     _h_ += this.message.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.receiverroleid).append(",");
/*  98 */     _sb_.append(this.itemid).append(",");
/*  99 */     _sb_.append(this.itemnum).append(",");
/* 100 */     _sb_.append("T").append(this.message.length()).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CGiveFlowerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */