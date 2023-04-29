/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSendCommand
/*     */   extends __SSendCommand__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619277;
/*     */   public int phaseid;
/*     */   public int round;
/*     */   public int times;
/*     */   public ArrayList<Integer> commandlist;
/*     */   public long endtimestamp;
/*     */   public long currtimestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619277;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendCommand()
/*     */   {
/*  38 */     this.commandlist = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSendCommand(int _phaseid_, int _round_, int _times_, ArrayList<Integer> _commandlist_, long _endtimestamp_, long _currtimestamp_) {
/*  42 */     this.phaseid = _phaseid_;
/*  43 */     this.round = _round_;
/*  44 */     this.times = _times_;
/*  45 */     this.commandlist = _commandlist_;
/*  46 */     this.endtimestamp = _endtimestamp_;
/*  47 */     this.currtimestamp = _currtimestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.phaseid);
/*  56 */     _os_.marshal(this.round);
/*  57 */     _os_.marshal(this.times);
/*  58 */     _os_.compact_uint32(this.commandlist.size());
/*  59 */     for (Integer _v_ : this.commandlist) {
/*  60 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  62 */     _os_.marshal(this.endtimestamp);
/*  63 */     _os_.marshal(this.currtimestamp);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.phaseid = _os_.unmarshal_int();
/*  69 */     this.round = _os_.unmarshal_int();
/*  70 */     this.times = _os_.unmarshal_int();
/*  71 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  73 */       int _v_ = _os_.unmarshal_int();
/*  74 */       this.commandlist.add(Integer.valueOf(_v_));
/*     */     }
/*  76 */     this.endtimestamp = _os_.unmarshal_long();
/*  77 */     this.currtimestamp = _os_.unmarshal_long();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SSendCommand)) {
/*  87 */       SSendCommand _o_ = (SSendCommand)_o1_;
/*  88 */       if (this.phaseid != _o_.phaseid) return false;
/*  89 */       if (this.round != _o_.round) return false;
/*  90 */       if (this.times != _o_.times) return false;
/*  91 */       if (!this.commandlist.equals(_o_.commandlist)) return false;
/*  92 */       if (this.endtimestamp != _o_.endtimestamp) return false;
/*  93 */       if (this.currtimestamp != _o_.currtimestamp) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.phaseid;
/* 102 */     _h_ += this.round;
/* 103 */     _h_ += this.times;
/* 104 */     _h_ += this.commandlist.hashCode();
/* 105 */     _h_ += (int)this.endtimestamp;
/* 106 */     _h_ += (int)this.currtimestamp;
/* 107 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 111 */     StringBuilder _sb_ = new StringBuilder();
/* 112 */     _sb_.append("(");
/* 113 */     _sb_.append(this.phaseid).append(",");
/* 114 */     _sb_.append(this.round).append(",");
/* 115 */     _sb_.append(this.times).append(",");
/* 116 */     _sb_.append(this.commandlist).append(",");
/* 117 */     _sb_.append(this.endtimestamp).append(",");
/* 118 */     _sb_.append(this.currtimestamp).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SSendCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */