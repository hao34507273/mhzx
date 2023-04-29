/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SGiveFlowerRes extends __SGiveFlowerRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584792;
/*     */   public long giverroleid;
/*     */   public String giverrolename;
/*     */   public long receiverroleid;
/*     */   public String receiverrolename;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   public int addintimacynum;
/*     */   public String message;
/*     */   public int effectid;
/*     */   public int isall;
/*     */   public int isbulletin;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584792;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGiveFlowerRes()
/*     */   {
/*  41 */     this.giverrolename = "";
/*  42 */     this.receiverrolename = "";
/*  43 */     this.message = "";
/*     */   }
/*     */   
/*     */   public SGiveFlowerRes(long _giverroleid_, String _giverrolename_, long _receiverroleid_, String _receiverrolename_, int _itemid_, int _itemnum_, int _addintimacynum_, String _message_, int _effectid_, int _isall_, int _isbulletin_) {
/*  47 */     this.giverroleid = _giverroleid_;
/*  48 */     this.giverrolename = _giverrolename_;
/*  49 */     this.receiverroleid = _receiverroleid_;
/*  50 */     this.receiverrolename = _receiverrolename_;
/*  51 */     this.itemid = _itemid_;
/*  52 */     this.itemnum = _itemnum_;
/*  53 */     this.addintimacynum = _addintimacynum_;
/*  54 */     this.message = _message_;
/*  55 */     this.effectid = _effectid_;
/*  56 */     this.isall = _isall_;
/*  57 */     this.isbulletin = _isbulletin_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.giverroleid);
/*  66 */     _os_.marshal(this.giverrolename, "UTF-16LE");
/*  67 */     _os_.marshal(this.receiverroleid);
/*  68 */     _os_.marshal(this.receiverrolename, "UTF-16LE");
/*  69 */     _os_.marshal(this.itemid);
/*  70 */     _os_.marshal(this.itemnum);
/*  71 */     _os_.marshal(this.addintimacynum);
/*  72 */     _os_.marshal(this.message, "UTF-16LE");
/*  73 */     _os_.marshal(this.effectid);
/*  74 */     _os_.marshal(this.isall);
/*  75 */     _os_.marshal(this.isbulletin);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  80 */     this.giverroleid = _os_.unmarshal_long();
/*  81 */     this.giverrolename = _os_.unmarshal_String("UTF-16LE");
/*  82 */     this.receiverroleid = _os_.unmarshal_long();
/*  83 */     this.receiverrolename = _os_.unmarshal_String("UTF-16LE");
/*  84 */     this.itemid = _os_.unmarshal_int();
/*  85 */     this.itemnum = _os_.unmarshal_int();
/*  86 */     this.addintimacynum = _os_.unmarshal_int();
/*  87 */     this.message = _os_.unmarshal_String("UTF-16LE");
/*  88 */     this.effectid = _os_.unmarshal_int();
/*  89 */     this.isall = _os_.unmarshal_int();
/*  90 */     this.isbulletin = _os_.unmarshal_int();
/*  91 */     if (!_validator_()) {
/*  92 */       throw new VerifyError("validator failed");
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  98 */     if (_o1_ == this) return true;
/*  99 */     if ((_o1_ instanceof SGiveFlowerRes)) {
/* 100 */       SGiveFlowerRes _o_ = (SGiveFlowerRes)_o1_;
/* 101 */       if (this.giverroleid != _o_.giverroleid) return false;
/* 102 */       if (!this.giverrolename.equals(_o_.giverrolename)) return false;
/* 103 */       if (this.receiverroleid != _o_.receiverroleid) return false;
/* 104 */       if (!this.receiverrolename.equals(_o_.receiverrolename)) return false;
/* 105 */       if (this.itemid != _o_.itemid) return false;
/* 106 */       if (this.itemnum != _o_.itemnum) return false;
/* 107 */       if (this.addintimacynum != _o_.addintimacynum) return false;
/* 108 */       if (!this.message.equals(_o_.message)) return false;
/* 109 */       if (this.effectid != _o_.effectid) return false;
/* 110 */       if (this.isall != _o_.isall) return false;
/* 111 */       if (this.isbulletin != _o_.isbulletin) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += (int)this.giverroleid;
/* 120 */     _h_ += this.giverrolename.hashCode();
/* 121 */     _h_ += (int)this.receiverroleid;
/* 122 */     _h_ += this.receiverrolename.hashCode();
/* 123 */     _h_ += this.itemid;
/* 124 */     _h_ += this.itemnum;
/* 125 */     _h_ += this.addintimacynum;
/* 126 */     _h_ += this.message.hashCode();
/* 127 */     _h_ += this.effectid;
/* 128 */     _h_ += this.isall;
/* 129 */     _h_ += this.isbulletin;
/* 130 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 134 */     StringBuilder _sb_ = new StringBuilder();
/* 135 */     _sb_.append("(");
/* 136 */     _sb_.append(this.giverroleid).append(",");
/* 137 */     _sb_.append("T").append(this.giverrolename.length()).append(",");
/* 138 */     _sb_.append(this.receiverroleid).append(",");
/* 139 */     _sb_.append("T").append(this.receiverrolename.length()).append(",");
/* 140 */     _sb_.append(this.itemid).append(",");
/* 141 */     _sb_.append(this.itemnum).append(",");
/* 142 */     _sb_.append(this.addintimacynum).append(",");
/* 143 */     _sb_.append("T").append(this.message.length()).append(",");
/* 144 */     _sb_.append(this.effectid).append(",");
/* 145 */     _sb_.append(this.isall).append(",");
/* 146 */     _sb_.append(this.isbulletin).append(",");
/* 147 */     _sb_.append(")");
/* 148 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SGiveFlowerRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */