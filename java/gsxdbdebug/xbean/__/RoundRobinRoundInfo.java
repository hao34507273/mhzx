/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class RoundRobinRoundInfo extends XBean implements xbean.RoundRobinRoundInfo
/*     */ {
/*     */   private int stage;
/*     */   private ArrayList<xbean.RoundRobinFightInfo> fight_infos;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.stage = 0;
/*  21 */     this.fight_infos.clear();
/*     */   }
/*     */   
/*     */   RoundRobinRoundInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.fight_infos = new ArrayList();
/*     */   }
/*     */   
/*     */   public RoundRobinRoundInfo()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RoundRobinRoundInfo(RoundRobinRoundInfo _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RoundRobinRoundInfo(xbean.RoundRobinRoundInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof RoundRobinRoundInfo)) { assign((RoundRobinRoundInfo)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RoundRobinRoundInfo _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.stage = _o_.stage;
/*  53 */     this.fight_infos = new ArrayList();
/*  54 */     for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos) {
/*  55 */       this.fight_infos.add(new RoundRobinFightInfo(_v_, this, "fight_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  60 */     this.stage = _o_.stage;
/*  61 */     this.fight_infos = new ArrayList();
/*  62 */     for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos) {
/*  63 */       this.fight_infos.add(new RoundRobinFightInfo(_v_, this, "fight_infos"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.stage);
/*  71 */     _os_.compact_uint32(this.fight_infos.size());
/*  72 */     for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */     {
/*  74 */       _v_.marshal(_os_);
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.stage = _os_.unmarshal_int();
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       xbean.RoundRobinFightInfo _v_ = new RoundRobinFightInfo(0, this, "fight_infos");
/*  87 */       _v_.unmarshal(_os_);
/*  88 */       this.fight_infos.add(_v_);
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/*  99 */     for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */     {
/* 101 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */     }
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeInt32(1, this.stage);
/* 113 */       for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */       {
/* 115 */         _output_.writeMessage(2, _v_);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 120 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 122 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 128 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 131 */       boolean done = false;
/* 132 */       while (!done)
/*     */       {
/* 134 */         int tag = _input_.readTag();
/* 135 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 139 */           done = true;
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 144 */           this.stage = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 149 */           xbean.RoundRobinFightInfo _v_ = new RoundRobinFightInfo(0, this, "fight_infos");
/* 150 */           _input_.readMessage(_v_);
/* 151 */           this.fight_infos.add(_v_);
/* 152 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 156 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 158 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 167 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoundRobinRoundInfo copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new RoundRobinRoundInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoundRobinRoundInfo toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoundRobinRoundInfo toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new RoundRobinRoundInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RoundRobinRoundInfo toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RoundRobinRoundInfo toBeanIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getStage()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.stage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.RoundRobinFightInfo> getFight_infos()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return xdb.Logs.logList(new LogKey(this, "fight_infos"), this.fight_infos);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.RoundRobinFightInfo> getFight_infosAsData()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/*     */     
/* 237 */     RoundRobinRoundInfo _o_ = this;
/* 238 */     List<xbean.RoundRobinFightInfo> fight_infos = new ArrayList();
/* 239 */     for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos)
/* 240 */       fight_infos.add(new RoundRobinFightInfo.Data(_v_));
/* 241 */     return fight_infos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStage(int _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     xdb.Logs.logIf(new LogKey(this, "stage")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 253 */         new xdb.logs.LogInt(this, RoundRobinRoundInfo.this.stage)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             RoundRobinRoundInfo.this.stage = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.stage = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     RoundRobinRoundInfo _o_ = null;
/* 270 */     if ((_o1_ instanceof RoundRobinRoundInfo)) { _o_ = (RoundRobinRoundInfo)_o1_;
/* 271 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 272 */       return false;
/* 273 */     if (this.stage != _o_.stage) return false;
/* 274 */     if (!this.fight_infos.equals(_o_.fight_infos)) return false;
/* 275 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     int _h_ = 0;
/* 283 */     _h_ += this.stage;
/* 284 */     _h_ += this.fight_infos.hashCode();
/* 285 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     StringBuilder _sb_ = new StringBuilder();
/* 293 */     _sb_.append("(");
/* 294 */     _sb_.append(this.stage);
/* 295 */     _sb_.append(",");
/* 296 */     _sb_.append(this.fight_infos);
/* 297 */     _sb_.append(")");
/* 298 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 304 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 305 */     lb.add(new xdb.logs.ListenableChanged().setVarName("stage"));
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("fight_infos"));
/* 307 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RoundRobinRoundInfo {
/*     */     private Const() {}
/*     */     
/*     */     RoundRobinRoundInfo nThis() {
/* 314 */       return RoundRobinRoundInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 320 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo copy()
/*     */     {
/* 326 */       return RoundRobinRoundInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo toData()
/*     */     {
/* 332 */       return RoundRobinRoundInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RoundRobinRoundInfo toBean()
/*     */     {
/* 337 */       return RoundRobinRoundInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo toDataIf()
/*     */     {
/* 343 */       return RoundRobinRoundInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RoundRobinRoundInfo toBeanIf()
/*     */     {
/* 348 */       return RoundRobinRoundInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 355 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 356 */       return RoundRobinRoundInfo.this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoundRobinFightInfo> getFight_infos()
/*     */     {
/* 363 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 364 */       return xdb.Consts.constList(RoundRobinRoundInfo.this.fight_infos);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.RoundRobinFightInfo> getFight_infosAsData()
/*     */     {
/* 370 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/*     */       
/* 372 */       RoundRobinRoundInfo _o_ = RoundRobinRoundInfo.this;
/* 373 */       List<xbean.RoundRobinFightInfo> fight_infos = new ArrayList();
/* 374 */       for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos)
/* 375 */         fight_infos.add(new RoundRobinFightInfo.Data(_v_));
/* 376 */       return fight_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 383 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 384 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 390 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 391 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 397 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 398 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 404 */       return RoundRobinRoundInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       return RoundRobinRoundInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 416 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 423 */       return RoundRobinRoundInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 429 */       return RoundRobinRoundInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       RoundRobinRoundInfo.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 442 */       return RoundRobinRoundInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 448 */       return RoundRobinRoundInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 454 */       return RoundRobinRoundInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 460 */       return RoundRobinRoundInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 466 */       return RoundRobinRoundInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 472 */       return RoundRobinRoundInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 478 */       return RoundRobinRoundInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RoundRobinRoundInfo
/*     */   {
/*     */     private int stage;
/*     */     
/*     */     private ArrayList<xbean.RoundRobinFightInfo> fight_infos;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 497 */       this.fight_infos = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.RoundRobinRoundInfo _o1_)
/*     */     {
/* 502 */       if ((_o1_ instanceof RoundRobinRoundInfo)) { assign((RoundRobinRoundInfo)_o1_);
/* 503 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 504 */       } else if ((_o1_ instanceof RoundRobinRoundInfo.Const)) assign(((RoundRobinRoundInfo.Const)_o1_).nThis()); else {
/* 505 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RoundRobinRoundInfo _o_) {
/* 510 */       this.stage = _o_.stage;
/* 511 */       this.fight_infos = new ArrayList();
/* 512 */       for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos) {
/* 513 */         this.fight_infos.add(new RoundRobinFightInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 518 */       this.stage = _o_.stage;
/* 519 */       this.fight_infos = new ArrayList();
/* 520 */       for (xbean.RoundRobinFightInfo _v_ : _o_.fight_infos) {
/* 521 */         this.fight_infos.add(new RoundRobinFightInfo.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 527 */       _os_.marshal(this.stage);
/* 528 */       _os_.compact_uint32(this.fight_infos.size());
/* 529 */       for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */       {
/* 531 */         _v_.marshal(_os_);
/*     */       }
/* 533 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       this.stage = _os_.unmarshal_int();
/* 540 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 542 */         xbean.RoundRobinFightInfo _v_ = xbean.Pod.newRoundRobinFightInfoData();
/* 543 */         _v_.unmarshal(_os_);
/* 544 */         this.fight_infos.add(_v_);
/*     */       }
/* 546 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 552 */       int _size_ = 0;
/* 553 */       _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/* 554 */       for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */       {
/* 556 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */       }
/* 558 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 566 */         _output_.writeInt32(1, this.stage);
/* 567 */         for (xbean.RoundRobinFightInfo _v_ : this.fight_infos)
/*     */         {
/* 569 */           _output_.writeMessage(2, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 574 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 576 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 584 */         boolean done = false;
/* 585 */         while (!done)
/*     */         {
/* 587 */           int tag = _input_.readTag();
/* 588 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 592 */             done = true;
/* 593 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 597 */             this.stage = _input_.readInt32();
/* 598 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 602 */             xbean.RoundRobinFightInfo _v_ = xbean.Pod.newRoundRobinFightInfoData();
/* 603 */             _input_.readMessage(_v_);
/* 604 */             this.fight_infos.add(_v_);
/* 605 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 609 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 611 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 620 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 624 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 626 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo copy()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo toData()
/*     */     {
/* 638 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RoundRobinRoundInfo toBean()
/*     */     {
/* 643 */       return new RoundRobinRoundInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RoundRobinRoundInfo toDataIf()
/*     */     {
/* 649 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RoundRobinRoundInfo toBeanIf()
/*     */     {
/* 654 */       return new RoundRobinRoundInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 660 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 664 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 668 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 672 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 676 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 680 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 684 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getStage()
/*     */     {
/* 691 */       return this.stage;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoundRobinFightInfo> getFight_infos()
/*     */     {
/* 698 */       return this.fight_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RoundRobinFightInfo> getFight_infosAsData()
/*     */     {
/* 705 */       return this.fight_infos;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStage(int _v_)
/*     */     {
/* 712 */       this.stage = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 718 */       if (!(_o1_ instanceof Data)) return false;
/* 719 */       Data _o_ = (Data)_o1_;
/* 720 */       if (this.stage != _o_.stage) return false;
/* 721 */       if (!this.fight_infos.equals(_o_.fight_infos)) return false;
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 728 */       int _h_ = 0;
/* 729 */       _h_ += this.stage;
/* 730 */       _h_ += this.fight_infos.hashCode();
/* 731 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 737 */       StringBuilder _sb_ = new StringBuilder();
/* 738 */       _sb_.append("(");
/* 739 */       _sb_.append(this.stage);
/* 740 */       _sb_.append(",");
/* 741 */       _sb_.append(this.fight_infos);
/* 742 */       _sb_.append(")");
/* 743 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoundRobinRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */