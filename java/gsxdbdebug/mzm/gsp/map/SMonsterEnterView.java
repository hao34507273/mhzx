/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMonsterEnterView
/*     */   extends __SMonsterEnterView__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590871;
/*     */   public int monsterinstanceid;
/*     */   public int monsterid;
/*     */   public int isactive;
/*     */   public String monstername;
/*     */   public EnterPosition posinit;
/*     */   public byte is_fighting;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12590871;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMonsterEnterView()
/*     */   {
/*  38 */     this.monstername = "";
/*  39 */     this.posinit = new EnterPosition();
/*     */   }
/*     */   
/*     */   public SMonsterEnterView(int _monsterinstanceid_, int _monsterid_, int _isactive_, String _monstername_, EnterPosition _posinit_, byte _is_fighting_) {
/*  43 */     this.monsterinstanceid = _monsterinstanceid_;
/*  44 */     this.monsterid = _monsterid_;
/*  45 */     this.isactive = _isactive_;
/*  46 */     this.monstername = _monstername_;
/*  47 */     this.posinit = _posinit_;
/*  48 */     this.is_fighting = _is_fighting_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     if (!this.posinit._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.monsterinstanceid);
/*  58 */     _os_.marshal(this.monsterid);
/*  59 */     _os_.marshal(this.isactive);
/*  60 */     _os_.marshal(this.monstername, "UTF-16LE");
/*  61 */     _os_.marshal(this.posinit);
/*  62 */     _os_.marshal(this.is_fighting);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.monsterinstanceid = _os_.unmarshal_int();
/*  68 */     this.monsterid = _os_.unmarshal_int();
/*  69 */     this.isactive = _os_.unmarshal_int();
/*  70 */     this.monstername = _os_.unmarshal_String("UTF-16LE");
/*  71 */     this.posinit.unmarshal(_os_);
/*  72 */     this.is_fighting = _os_.unmarshal_byte();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SMonsterEnterView)) {
/*  82 */       SMonsterEnterView _o_ = (SMonsterEnterView)_o1_;
/*  83 */       if (this.monsterinstanceid != _o_.monsterinstanceid) return false;
/*  84 */       if (this.monsterid != _o_.monsterid) return false;
/*  85 */       if (this.isactive != _o_.isactive) return false;
/*  86 */       if (!this.monstername.equals(_o_.monstername)) return false;
/*  87 */       if (!this.posinit.equals(_o_.posinit)) return false;
/*  88 */       if (this.is_fighting != _o_.is_fighting) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.monsterinstanceid;
/*  97 */     _h_ += this.monsterid;
/*  98 */     _h_ += this.isactive;
/*  99 */     _h_ += this.monstername.hashCode();
/* 100 */     _h_ += this.posinit.hashCode();
/* 101 */     _h_ += this.is_fighting;
/* 102 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 106 */     StringBuilder _sb_ = new StringBuilder();
/* 107 */     _sb_.append("(");
/* 108 */     _sb_.append(this.monsterinstanceid).append(",");
/* 109 */     _sb_.append(this.monsterid).append(",");
/* 110 */     _sb_.append(this.isactive).append(",");
/* 111 */     _sb_.append("T").append(this.monstername.length()).append(",");
/* 112 */     _sb_.append(this.posinit).append(",");
/* 113 */     _sb_.append(this.is_fighting).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SMonsterEnterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */