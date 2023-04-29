/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class Ceremonys extends XBean implements xbean.Ceremonys
/*     */ {
/*     */   private LinkedList<xbean.Ceremony> ceremonys;
/*     */   private int ceremonycounter;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.ceremonys.clear();
/*  21 */     this.ceremonycounter = 0;
/*     */   }
/*     */   
/*     */   Ceremonys(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.ceremonys = new LinkedList();
/*     */   }
/*     */   
/*     */   public Ceremonys()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Ceremonys(Ceremonys _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Ceremonys(xbean.Ceremonys _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof Ceremonys)) { assign((Ceremonys)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Ceremonys _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.ceremonys = new LinkedList();
/*  53 */     for (xbean.Ceremony _v_ : _o_.ceremonys)
/*  54 */       this.ceremonys.add(new Ceremony(_v_, this, "ceremonys"));
/*  55 */     this.ceremonycounter = _o_.ceremonycounter;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  60 */     this.ceremonys = new LinkedList();
/*  61 */     for (xbean.Ceremony _v_ : _o_.ceremonys)
/*  62 */       this.ceremonys.add(new Ceremony(_v_, this, "ceremonys"));
/*  63 */     this.ceremonycounter = _o_.ceremonycounter;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.compact_uint32(this.ceremonys.size());
/*  71 */     for (xbean.Ceremony _v_ : this.ceremonys)
/*     */     {
/*  73 */       _v_.marshal(_os_);
/*     */     }
/*  75 */     _os_.marshal(this.ceremonycounter);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       xbean.Ceremony _v_ = new Ceremony(0, this, "ceremonys");
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.ceremonys.add(_v_);
/*     */     }
/*  89 */     this.ceremonycounter = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     for (xbean.Ceremony _v_ : this.ceremonys)
/*     */     {
/* 100 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(2, this.ceremonycounter);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       for (xbean.Ceremony _v_ : this.ceremonys)
/*     */       {
/* 114 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 116 */       _output_.writeInt32(2, this.ceremonycounter);
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
/*     */         case 10: 
/* 144 */           xbean.Ceremony _v_ = new Ceremony(0, this, "ceremonys");
/* 145 */           _input_.readMessage(_v_);
/* 146 */           this.ceremonys.add(_v_);
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 151 */           this.ceremonycounter = _input_.readInt32();
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
/*     */   public xbean.Ceremonys copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Ceremonys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Ceremonys toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Ceremonys toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Ceremonys(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Ceremonys toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Ceremonys toBeanIf()
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
/*     */   public List<xbean.Ceremony> getCeremonys()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return xdb.Logs.logList(new LogKey(this, "ceremonys"), this.ceremonys);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.Ceremony> getCeremonysAsData()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/*     */     
/* 229 */     Ceremonys _o_ = this;
/* 230 */     List<xbean.Ceremony> ceremonys = new LinkedList();
/* 231 */     for (xbean.Ceremony _v_ : _o_.ceremonys)
/* 232 */       ceremonys.add(new Ceremony.Data(_v_));
/* 233 */     return ceremonys;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCeremonycounter()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.ceremonycounter;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCeremonycounter(int _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     xdb.Logs.logIf(new LogKey(this, "ceremonycounter")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 253 */         new xdb.logs.LogInt(this, Ceremonys.this.ceremonycounter)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             Ceremonys.this.ceremonycounter = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.ceremonycounter = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     Ceremonys _o_ = null;
/* 270 */     if ((_o1_ instanceof Ceremonys)) { _o_ = (Ceremonys)_o1_;
/* 271 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 272 */       return false;
/* 273 */     if (!this.ceremonys.equals(_o_.ceremonys)) return false;
/* 274 */     if (this.ceremonycounter != _o_.ceremonycounter) return false;
/* 275 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     int _h_ = 0;
/* 283 */     _h_ += this.ceremonys.hashCode();
/* 284 */     _h_ += this.ceremonycounter;
/* 285 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 291 */     _xdb_verify_unsafe_();
/* 292 */     StringBuilder _sb_ = new StringBuilder();
/* 293 */     _sb_.append("(");
/* 294 */     _sb_.append(this.ceremonys);
/* 295 */     _sb_.append(",");
/* 296 */     _sb_.append(this.ceremonycounter);
/* 297 */     _sb_.append(")");
/* 298 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 304 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 305 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ceremonys"));
/* 306 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ceremonycounter"));
/* 307 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Ceremonys {
/*     */     private Const() {}
/*     */     
/*     */     Ceremonys nThis() {
/* 314 */       return Ceremonys.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 320 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremonys copy()
/*     */     {
/* 326 */       return Ceremonys.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremonys toData()
/*     */     {
/* 332 */       return Ceremonys.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Ceremonys toBean()
/*     */     {
/* 337 */       return Ceremonys.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremonys toDataIf()
/*     */     {
/* 343 */       return Ceremonys.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Ceremonys toBeanIf()
/*     */     {
/* 348 */       return Ceremonys.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.Ceremony> getCeremonys()
/*     */     {
/* 355 */       Ceremonys.this._xdb_verify_unsafe_();
/* 356 */       return xdb.Consts.constList(Ceremonys.this.ceremonys);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.Ceremony> getCeremonysAsData()
/*     */     {
/* 362 */       Ceremonys.this._xdb_verify_unsafe_();
/*     */       
/* 364 */       Ceremonys _o_ = Ceremonys.this;
/* 365 */       List<xbean.Ceremony> ceremonys = new LinkedList();
/* 366 */       for (xbean.Ceremony _v_ : _o_.ceremonys)
/* 367 */         ceremonys.add(new Ceremony.Data(_v_));
/* 368 */       return ceremonys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCeremonycounter()
/*     */     {
/* 375 */       Ceremonys.this._xdb_verify_unsafe_();
/* 376 */       return Ceremonys.this.ceremonycounter;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCeremonycounter(int _v_)
/*     */     {
/* 383 */       Ceremonys.this._xdb_verify_unsafe_();
/* 384 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 390 */       Ceremonys.this._xdb_verify_unsafe_();
/* 391 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 397 */       Ceremonys.this._xdb_verify_unsafe_();
/* 398 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 404 */       return Ceremonys.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       return Ceremonys.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 416 */       Ceremonys.this._xdb_verify_unsafe_();
/* 417 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 423 */       return Ceremonys.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 429 */       return Ceremonys.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 435 */       Ceremonys.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 442 */       return Ceremonys.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 448 */       return Ceremonys.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 454 */       return Ceremonys.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 460 */       return Ceremonys.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 466 */       return Ceremonys.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 472 */       return Ceremonys.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 478 */       return Ceremonys.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Ceremonys
/*     */   {
/*     */     private LinkedList<xbean.Ceremony> ceremonys;
/*     */     
/*     */     private int ceremonycounter;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 492 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 497 */       this.ceremonys = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.Ceremonys _o1_)
/*     */     {
/* 502 */       if ((_o1_ instanceof Ceremonys)) { assign((Ceremonys)_o1_);
/* 503 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 504 */       } else if ((_o1_ instanceof Ceremonys.Const)) assign(((Ceremonys.Const)_o1_).nThis()); else {
/* 505 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Ceremonys _o_) {
/* 510 */       this.ceremonys = new LinkedList();
/* 511 */       for (xbean.Ceremony _v_ : _o_.ceremonys)
/* 512 */         this.ceremonys.add(new Ceremony.Data(_v_));
/* 513 */       this.ceremonycounter = _o_.ceremonycounter;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 518 */       this.ceremonys = new LinkedList();
/* 519 */       for (xbean.Ceremony _v_ : _o_.ceremonys)
/* 520 */         this.ceremonys.add(new Ceremony.Data(_v_));
/* 521 */       this.ceremonycounter = _o_.ceremonycounter;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 527 */       _os_.compact_uint32(this.ceremonys.size());
/* 528 */       for (xbean.Ceremony _v_ : this.ceremonys)
/*     */       {
/* 530 */         _v_.marshal(_os_);
/*     */       }
/* 532 */       _os_.marshal(this.ceremonycounter);
/* 533 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 539 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 541 */         xbean.Ceremony _v_ = xbean.Pod.newCeremonyData();
/* 542 */         _v_.unmarshal(_os_);
/* 543 */         this.ceremonys.add(_v_);
/*     */       }
/* 545 */       this.ceremonycounter = _os_.unmarshal_int();
/* 546 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 552 */       int _size_ = 0;
/* 553 */       for (xbean.Ceremony _v_ : this.ceremonys)
/*     */       {
/* 555 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 557 */       _size_ += CodedOutputStream.computeInt32Size(2, this.ceremonycounter);
/* 558 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 566 */         for (xbean.Ceremony _v_ : this.ceremonys)
/*     */         {
/* 568 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 570 */         _output_.writeInt32(2, this.ceremonycounter);
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
/*     */           case 10: 
/* 597 */             xbean.Ceremony _v_ = xbean.Pod.newCeremonyData();
/* 598 */             _input_.readMessage(_v_);
/* 599 */             this.ceremonys.add(_v_);
/* 600 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 604 */             this.ceremonycounter = _input_.readInt32();
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
/*     */     public xbean.Ceremonys copy()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremonys toData()
/*     */     {
/* 638 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Ceremonys toBean()
/*     */     {
/* 643 */       return new Ceremonys(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Ceremonys toDataIf()
/*     */     {
/* 649 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Ceremonys toBeanIf()
/*     */     {
/* 654 */       return new Ceremonys(this, null, null);
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
/*     */     public List<xbean.Ceremony> getCeremonys()
/*     */     {
/* 691 */       return this.ceremonys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.Ceremony> getCeremonysAsData()
/*     */     {
/* 698 */       return this.ceremonys;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCeremonycounter()
/*     */     {
/* 705 */       return this.ceremonycounter;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCeremonycounter(int _v_)
/*     */     {
/* 712 */       this.ceremonycounter = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 718 */       if (!(_o1_ instanceof Data)) return false;
/* 719 */       Data _o_ = (Data)_o1_;
/* 720 */       if (!this.ceremonys.equals(_o_.ceremonys)) return false;
/* 721 */       if (this.ceremonycounter != _o_.ceremonycounter) return false;
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 728 */       int _h_ = 0;
/* 729 */       _h_ += this.ceremonys.hashCode();
/* 730 */       _h_ += this.ceremonycounter;
/* 731 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 737 */       StringBuilder _sb_ = new StringBuilder();
/* 738 */       _sb_.append("(");
/* 739 */       _sb_.append(this.ceremonys);
/* 740 */       _sb_.append(",");
/* 741 */       _sb_.append(this.ceremonycounter);
/* 742 */       _sb_.append(")");
/* 743 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Ceremonys.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */