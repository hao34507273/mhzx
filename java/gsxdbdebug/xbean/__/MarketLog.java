/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class MarketLog extends XBean implements xbean.MarketLog
/*     */ {
/*     */   private LinkedList<xbean.SaleLog> selllog;
/*     */   private LinkedList<xbean.SaleLog> buylog;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.selllog.clear();
/*  21 */     this.buylog.clear();
/*     */   }
/*     */   
/*     */   MarketLog(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.selllog = new LinkedList();
/*  28 */     this.buylog = new LinkedList();
/*     */   }
/*     */   
/*     */   public MarketLog()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarketLog(MarketLog _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarketLog(xbean.MarketLog _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof MarketLog)) { assign((MarketLog)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarketLog _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.selllog = new LinkedList();
/*  54 */     for (xbean.SaleLog _v_ : _o_.selllog)
/*  55 */       this.selllog.add(new SaleLog(_v_, this, "selllog"));
/*  56 */     this.buylog = new LinkedList();
/*  57 */     for (xbean.SaleLog _v_ : _o_.buylog) {
/*  58 */       this.buylog.add(new SaleLog(_v_, this, "buylog"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  63 */     this.selllog = new LinkedList();
/*  64 */     for (xbean.SaleLog _v_ : _o_.selllog)
/*  65 */       this.selllog.add(new SaleLog(_v_, this, "selllog"));
/*  66 */     this.buylog = new LinkedList();
/*  67 */     for (xbean.SaleLog _v_ : _o_.buylog) {
/*  68 */       this.buylog.add(new SaleLog(_v_, this, "buylog"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.compact_uint32(this.selllog.size());
/*  76 */     for (xbean.SaleLog _v_ : this.selllog)
/*     */     {
/*  78 */       _v_.marshal(_os_);
/*     */     }
/*  80 */     _os_.compact_uint32(this.buylog.size());
/*  81 */     for (xbean.SaleLog _v_ : this.buylog)
/*     */     {
/*  83 */       _v_.marshal(_os_);
/*     */     }
/*  85 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  91 */     _xdb_verify_unsafe_();
/*  92 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  94 */       xbean.SaleLog _v_ = new SaleLog(0, this, "selllog");
/*  95 */       _v_.unmarshal(_os_);
/*  96 */       this.selllog.add(_v_);
/*     */     }
/*  98 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 100 */       xbean.SaleLog _v_ = new SaleLog(0, this, "buylog");
/* 101 */       _v_.unmarshal(_os_);
/* 102 */       this.buylog.add(_v_);
/*     */     }
/* 104 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/* 111 */     int _size_ = 0;
/* 112 */     for (xbean.SaleLog _v_ : this.selllog)
/*     */     {
/* 114 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/* 116 */     for (xbean.SaleLog _v_ : this.buylog)
/*     */     {
/* 118 */       _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */     }
/* 120 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       for (xbean.SaleLog _v_ : this.selllog)
/*     */       {
/* 131 */         _output_.writeMessage(1, _v_);
/*     */       }
/* 133 */       for (xbean.SaleLog _v_ : this.buylog)
/*     */       {
/* 135 */         _output_.writeMessage(2, _v_);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 140 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 142 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 148 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 151 */       boolean done = false;
/* 152 */       while (!done)
/*     */       {
/* 154 */         int tag = _input_.readTag();
/* 155 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 159 */           done = true;
/* 160 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 164 */           xbean.SaleLog _v_ = new SaleLog(0, this, "selllog");
/* 165 */           _input_.readMessage(_v_);
/* 166 */           this.selllog.add(_v_);
/* 167 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 171 */           xbean.SaleLog _v_ = new SaleLog(0, this, "buylog");
/* 172 */           _input_.readMessage(_v_);
/* 173 */           this.buylog.add(_v_);
/* 174 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 178 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 180 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 189 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 193 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 195 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketLog copy()
/*     */   {
/* 201 */     _xdb_verify_unsafe_();
/* 202 */     return new MarketLog(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketLog toData()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketLog toBean()
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     return new MarketLog(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketLog toDataIf()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketLog toBeanIf()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.SaleLog> getSelllog()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return xdb.Logs.logList(new xdb.LogKey(this, "selllog"), this.selllog);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.SaleLog> getSelllogAsData()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/*     */     
/* 251 */     MarketLog _o_ = this;
/* 252 */     List<xbean.SaleLog> selllog = new LinkedList();
/* 253 */     for (xbean.SaleLog _v_ : _o_.selllog)
/* 254 */       selllog.add(new SaleLog.Data(_v_));
/* 255 */     return selllog;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.SaleLog> getBuylog()
/*     */   {
/* 262 */     _xdb_verify_unsafe_();
/* 263 */     return xdb.Logs.logList(new xdb.LogKey(this, "buylog"), this.buylog);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.SaleLog> getBuylogAsData()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/*     */     
/* 271 */     MarketLog _o_ = this;
/* 272 */     List<xbean.SaleLog> buylog = new LinkedList();
/* 273 */     for (xbean.SaleLog _v_ : _o_.buylog)
/* 274 */       buylog.add(new SaleLog.Data(_v_));
/* 275 */     return buylog;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     MarketLog _o_ = null;
/* 283 */     if ((_o1_ instanceof MarketLog)) { _o_ = (MarketLog)_o1_;
/* 284 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 285 */       return false;
/* 286 */     if (!this.selllog.equals(_o_.selllog)) return false;
/* 287 */     if (!this.buylog.equals(_o_.buylog)) return false;
/* 288 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     int _h_ = 0;
/* 296 */     _h_ += this.selllog.hashCode();
/* 297 */     _h_ += this.buylog.hashCode();
/* 298 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 304 */     _xdb_verify_unsafe_();
/* 305 */     StringBuilder _sb_ = new StringBuilder();
/* 306 */     _sb_.append("(");
/* 307 */     _sb_.append(this.selllog);
/* 308 */     _sb_.append(",");
/* 309 */     _sb_.append(this.buylog);
/* 310 */     _sb_.append(")");
/* 311 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 317 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 318 */     lb.add(new xdb.logs.ListenableChanged().setVarName("selllog"));
/* 319 */     lb.add(new xdb.logs.ListenableChanged().setVarName("buylog"));
/* 320 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarketLog {
/*     */     private Const() {}
/*     */     
/*     */     MarketLog nThis() {
/* 327 */       return MarketLog.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 333 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog copy()
/*     */     {
/* 339 */       return MarketLog.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog toData()
/*     */     {
/* 345 */       return MarketLog.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarketLog toBean()
/*     */     {
/* 350 */       return MarketLog.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog toDataIf()
/*     */     {
/* 356 */       return MarketLog.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarketLog toBeanIf()
/*     */     {
/* 361 */       return MarketLog.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getSelllog()
/*     */     {
/* 368 */       MarketLog.this._xdb_verify_unsafe_();
/* 369 */       return xdb.Consts.constList(MarketLog.this.selllog);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.SaleLog> getSelllogAsData()
/*     */     {
/* 375 */       MarketLog.this._xdb_verify_unsafe_();
/*     */       
/* 377 */       MarketLog _o_ = MarketLog.this;
/* 378 */       List<xbean.SaleLog> selllog = new LinkedList();
/* 379 */       for (xbean.SaleLog _v_ : _o_.selllog)
/* 380 */         selllog.add(new SaleLog.Data(_v_));
/* 381 */       return selllog;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getBuylog()
/*     */     {
/* 388 */       MarketLog.this._xdb_verify_unsafe_();
/* 389 */       return xdb.Consts.constList(MarketLog.this.buylog);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.SaleLog> getBuylogAsData()
/*     */     {
/* 395 */       MarketLog.this._xdb_verify_unsafe_();
/*     */       
/* 397 */       MarketLog _o_ = MarketLog.this;
/* 398 */       List<xbean.SaleLog> buylog = new LinkedList();
/* 399 */       for (xbean.SaleLog _v_ : _o_.buylog)
/* 400 */         buylog.add(new SaleLog.Data(_v_));
/* 401 */       return buylog;
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 407 */       MarketLog.this._xdb_verify_unsafe_();
/* 408 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 414 */       MarketLog.this._xdb_verify_unsafe_();
/* 415 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 421 */       return MarketLog.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 427 */       return MarketLog.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 433 */       MarketLog.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 440 */       return MarketLog.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 446 */       return MarketLog.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 452 */       MarketLog.this._xdb_verify_unsafe_();
/* 453 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 459 */       return MarketLog.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 465 */       return MarketLog.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 471 */       return MarketLog.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 477 */       return MarketLog.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 483 */       return MarketLog.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 489 */       return MarketLog.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 495 */       return MarketLog.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarketLog
/*     */   {
/*     */     private LinkedList<xbean.SaleLog> selllog;
/*     */     
/*     */     private LinkedList<xbean.SaleLog> buylog;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 509 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 514 */       this.selllog = new LinkedList();
/* 515 */       this.buylog = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.MarketLog _o1_)
/*     */     {
/* 520 */       if ((_o1_ instanceof MarketLog)) { assign((MarketLog)_o1_);
/* 521 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 522 */       } else if ((_o1_ instanceof MarketLog.Const)) assign(((MarketLog.Const)_o1_).nThis()); else {
/* 523 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarketLog _o_) {
/* 528 */       this.selllog = new LinkedList();
/* 529 */       for (xbean.SaleLog _v_ : _o_.selllog)
/* 530 */         this.selllog.add(new SaleLog.Data(_v_));
/* 531 */       this.buylog = new LinkedList();
/* 532 */       for (xbean.SaleLog _v_ : _o_.buylog) {
/* 533 */         this.buylog.add(new SaleLog.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 538 */       this.selllog = new LinkedList();
/* 539 */       for (xbean.SaleLog _v_ : _o_.selllog)
/* 540 */         this.selllog.add(new SaleLog.Data(_v_));
/* 541 */       this.buylog = new LinkedList();
/* 542 */       for (xbean.SaleLog _v_ : _o_.buylog) {
/* 543 */         this.buylog.add(new SaleLog.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 549 */       _os_.compact_uint32(this.selllog.size());
/* 550 */       for (xbean.SaleLog _v_ : this.selllog)
/*     */       {
/* 552 */         _v_.marshal(_os_);
/*     */       }
/* 554 */       _os_.compact_uint32(this.buylog.size());
/* 555 */       for (xbean.SaleLog _v_ : this.buylog)
/*     */       {
/* 557 */         _v_.marshal(_os_);
/*     */       }
/* 559 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 565 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 567 */         xbean.SaleLog _v_ = xbean.Pod.newSaleLogData();
/* 568 */         _v_.unmarshal(_os_);
/* 569 */         this.selllog.add(_v_);
/*     */       }
/* 571 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 573 */         xbean.SaleLog _v_ = xbean.Pod.newSaleLogData();
/* 574 */         _v_.unmarshal(_os_);
/* 575 */         this.buylog.add(_v_);
/*     */       }
/* 577 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 583 */       int _size_ = 0;
/* 584 */       for (xbean.SaleLog _v_ : this.selllog)
/*     */       {
/* 586 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 588 */       for (xbean.SaleLog _v_ : this.buylog)
/*     */       {
/* 590 */         _size_ += CodedOutputStream.computeMessageSize(2, _v_);
/*     */       }
/* 592 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 600 */         for (xbean.SaleLog _v_ : this.selllog)
/*     */         {
/* 602 */           _output_.writeMessage(1, _v_);
/*     */         }
/* 604 */         for (xbean.SaleLog _v_ : this.buylog)
/*     */         {
/* 606 */           _output_.writeMessage(2, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 634 */             xbean.SaleLog _v_ = xbean.Pod.newSaleLogData();
/* 635 */             _input_.readMessage(_v_);
/* 636 */             this.selllog.add(_v_);
/* 637 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 641 */             xbean.SaleLog _v_ = xbean.Pod.newSaleLogData();
/* 642 */             _input_.readMessage(_v_);
/* 643 */             this.buylog.add(_v_);
/* 644 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 648 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 650 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 659 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 663 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 665 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog copy()
/*     */     {
/* 671 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog toData()
/*     */     {
/* 677 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarketLog toBean()
/*     */     {
/* 682 */       return new MarketLog(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketLog toDataIf()
/*     */     {
/* 688 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarketLog toBeanIf()
/*     */     {
/* 693 */       return new MarketLog(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 699 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 703 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 707 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 711 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 715 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 719 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 723 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getSelllog()
/*     */     {
/* 730 */       return this.selllog;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getSelllogAsData()
/*     */     {
/* 737 */       return this.selllog;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getBuylog()
/*     */     {
/* 744 */       return this.buylog;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.SaleLog> getBuylogAsData()
/*     */     {
/* 751 */       return this.buylog;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 757 */       if (!(_o1_ instanceof Data)) return false;
/* 758 */       Data _o_ = (Data)_o1_;
/* 759 */       if (!this.selllog.equals(_o_.selllog)) return false;
/* 760 */       if (!this.buylog.equals(_o_.buylog)) return false;
/* 761 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 767 */       int _h_ = 0;
/* 768 */       _h_ += this.selllog.hashCode();
/* 769 */       _h_ += this.buylog.hashCode();
/* 770 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 776 */       StringBuilder _sb_ = new StringBuilder();
/* 777 */       _sb_.append("(");
/* 778 */       _sb_.append(this.selllog);
/* 779 */       _sb_.append(",");
/* 780 */       _sb_.append(this.buylog);
/* 781 */       _sb_.append(")");
/* 782 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */