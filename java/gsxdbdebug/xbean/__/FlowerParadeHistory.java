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
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class FlowerParadeHistory extends XBean implements xbean.FlowerParadeHistory
/*     */ {
/*     */   private ArrayList<Long> historyroles;
/*     */   private ArrayList<Integer> historyocpids;
/*     */   private ArrayList<Integer> historymapids;
/*     */   private long paradeindex;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.historyroles.clear();
/*  25 */     this.historyocpids.clear();
/*  26 */     this.historymapids.clear();
/*  27 */     this.paradeindex = 0L;
/*     */   }
/*     */   
/*     */   FlowerParadeHistory(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.historyroles = new ArrayList();
/*  34 */     this.historyocpids = new ArrayList();
/*  35 */     this.historymapids = new ArrayList();
/*  36 */     this.paradeindex = 0L;
/*     */   }
/*     */   
/*     */   public FlowerParadeHistory()
/*     */   {
/*  41 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FlowerParadeHistory(FlowerParadeHistory _o_)
/*     */   {
/*  46 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FlowerParadeHistory(xbean.FlowerParadeHistory _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  51 */     super(_xp_, _vn_);
/*  52 */     if ((_o1_ instanceof FlowerParadeHistory)) { assign((FlowerParadeHistory)_o1_);
/*  53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  55 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FlowerParadeHistory _o_) {
/*  60 */     _o_._xdb_verify_unsafe_();
/*  61 */     this.historyroles = new ArrayList();
/*  62 */     this.historyroles.addAll(_o_.historyroles);
/*  63 */     this.historyocpids = new ArrayList();
/*  64 */     this.historyocpids.addAll(_o_.historyocpids);
/*  65 */     this.historymapids = new ArrayList();
/*  66 */     this.historymapids.addAll(_o_.historymapids);
/*  67 */     this.paradeindex = _o_.paradeindex;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  72 */     this.historyroles = new ArrayList();
/*  73 */     this.historyroles.addAll(_o_.historyroles);
/*  74 */     this.historyocpids = new ArrayList();
/*  75 */     this.historyocpids.addAll(_o_.historyocpids);
/*  76 */     this.historymapids = new ArrayList();
/*  77 */     this.historymapids.addAll(_o_.historymapids);
/*  78 */     this.paradeindex = _o_.paradeindex;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     _os_.compact_uint32(this.historyroles.size());
/*  86 */     for (Long _v_ : this.historyroles)
/*     */     {
/*  88 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  90 */     _os_.compact_uint32(this.historyocpids.size());
/*  91 */     for (Integer _v_ : this.historyocpids)
/*     */     {
/*  93 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  95 */     _os_.compact_uint32(this.historymapids.size());
/*  96 */     for (Integer _v_ : this.historymapids)
/*     */     {
/*  98 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 100 */     _os_.marshal(this.paradeindex);
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/* 108 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 110 */       long _v_ = 0L;
/* 111 */       _v_ = _os_.unmarshal_long();
/* 112 */       this.historyroles.add(Long.valueOf(_v_));
/*     */     }
/* 114 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 116 */       int _v_ = 0;
/* 117 */       _v_ = _os_.unmarshal_int();
/* 118 */       this.historyocpids.add(Integer.valueOf(_v_));
/*     */     }
/* 120 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 122 */       int _v_ = 0;
/* 123 */       _v_ = _os_.unmarshal_int();
/* 124 */       this.historymapids.add(Integer.valueOf(_v_));
/*     */     }
/* 126 */     this.paradeindex = _os_.unmarshal_long();
/* 127 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 133 */     _xdb_verify_unsafe_();
/* 134 */     int _size_ = 0;
/* 135 */     for (Long _v_ : this.historyroles)
/*     */     {
/* 137 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/* 139 */     for (Integer _v_ : this.historyocpids)
/*     */     {
/* 141 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 143 */     for (Integer _v_ : this.historymapids)
/*     */     {
/* 145 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 147 */     _size_ += CodedOutputStream.computeInt64Size(4, this.paradeindex);
/* 148 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 154 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 157 */       for (Long _v_ : this.historyroles)
/*     */       {
/* 159 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/* 161 */       for (Integer _v_ : this.historyocpids)
/*     */       {
/* 163 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 165 */       for (Integer _v_ : this.historymapids)
/*     */       {
/* 167 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/* 169 */       _output_.writeInt64(4, this.paradeindex);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 173 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 175 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 184 */       boolean done = false;
/* 185 */       while (!done)
/*     */       {
/* 187 */         int tag = _input_.readTag();
/* 188 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 192 */           done = true;
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 197 */           long _v_ = 0L;
/* 198 */           _v_ = _input_.readInt64();
/* 199 */           this.historyroles.add(Long.valueOf(_v_));
/* 200 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 204 */           int _v_ = 0;
/* 205 */           _v_ = _input_.readInt32();
/* 206 */           this.historyocpids.add(Integer.valueOf(_v_));
/* 207 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 211 */           int _v_ = 0;
/* 212 */           _v_ = _input_.readInt32();
/* 213 */           this.historymapids.add(Integer.valueOf(_v_));
/* 214 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 218 */           this.paradeindex = _input_.readInt64();
/* 219 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 223 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 225 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 234 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 238 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 240 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlowerParadeHistory copy()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     return new FlowerParadeHistory(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlowerParadeHistory toData()
/*     */   {
/* 253 */     _xdb_verify_unsafe_();
/* 254 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlowerParadeHistory toBean()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return new FlowerParadeHistory(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FlowerParadeHistory toDataIf()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FlowerParadeHistory toBeanIf()
/*     */   {
/* 272 */     _xdb_verify_unsafe_();
/* 273 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getHistoryroles()
/*     */   {
/* 287 */     _xdb_verify_unsafe_();
/* 288 */     return xdb.Logs.logList(new LogKey(this, "historyroles"), this.historyroles);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getHistoryrolesAsData()
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/*     */     
/* 296 */     FlowerParadeHistory _o_ = this;
/* 297 */     List<Long> historyroles = new ArrayList();
/* 298 */     historyroles.addAll(_o_.historyroles);
/* 299 */     return historyroles;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getHistoryocpids()
/*     */   {
/* 306 */     _xdb_verify_unsafe_();
/* 307 */     return xdb.Logs.logList(new LogKey(this, "historyocpids"), this.historyocpids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getHistoryocpidsAsData()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/*     */     
/* 315 */     FlowerParadeHistory _o_ = this;
/* 316 */     List<Integer> historyocpids = new ArrayList();
/* 317 */     historyocpids.addAll(_o_.historyocpids);
/* 318 */     return historyocpids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getHistorymapids()
/*     */   {
/* 325 */     _xdb_verify_unsafe_();
/* 326 */     return xdb.Logs.logList(new LogKey(this, "historymapids"), this.historymapids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getHistorymapidsAsData()
/*     */   {
/* 332 */     _xdb_verify_unsafe_();
/*     */     
/* 334 */     FlowerParadeHistory _o_ = this;
/* 335 */     List<Integer> historymapids = new ArrayList();
/* 336 */     historymapids.addAll(_o_.historymapids);
/* 337 */     return historymapids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getParadeindex()
/*     */   {
/* 344 */     _xdb_verify_unsafe_();
/* 345 */     return this.paradeindex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setParadeindex(long _v_)
/*     */   {
/* 352 */     _xdb_verify_unsafe_();
/* 353 */     xdb.Logs.logIf(new LogKey(this, "paradeindex")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 357 */         new xdb.logs.LogLong(this, FlowerParadeHistory.this.paradeindex)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 361 */             FlowerParadeHistory.this.paradeindex = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 365 */     });
/* 366 */     this.paradeindex = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 372 */     _xdb_verify_unsafe_();
/* 373 */     FlowerParadeHistory _o_ = null;
/* 374 */     if ((_o1_ instanceof FlowerParadeHistory)) { _o_ = (FlowerParadeHistory)_o1_;
/* 375 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 376 */       return false;
/* 377 */     if (!this.historyroles.equals(_o_.historyroles)) return false;
/* 378 */     if (!this.historyocpids.equals(_o_.historyocpids)) return false;
/* 379 */     if (!this.historymapids.equals(_o_.historymapids)) return false;
/* 380 */     if (this.paradeindex != _o_.paradeindex) return false;
/* 381 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 387 */     _xdb_verify_unsafe_();
/* 388 */     int _h_ = 0;
/* 389 */     _h_ += this.historyroles.hashCode();
/* 390 */     _h_ += this.historyocpids.hashCode();
/* 391 */     _h_ += this.historymapids.hashCode();
/* 392 */     _h_ = (int)(_h_ + this.paradeindex);
/* 393 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 399 */     _xdb_verify_unsafe_();
/* 400 */     StringBuilder _sb_ = new StringBuilder();
/* 401 */     _sb_.append("(");
/* 402 */     _sb_.append(this.historyroles);
/* 403 */     _sb_.append(",");
/* 404 */     _sb_.append(this.historyocpids);
/* 405 */     _sb_.append(",");
/* 406 */     _sb_.append(this.historymapids);
/* 407 */     _sb_.append(",");
/* 408 */     _sb_.append(this.paradeindex);
/* 409 */     _sb_.append(")");
/* 410 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 416 */     ListenableBean lb = new ListenableBean();
/* 417 */     lb.add(new ListenableChanged().setVarName("historyroles"));
/* 418 */     lb.add(new ListenableChanged().setVarName("historyocpids"));
/* 419 */     lb.add(new ListenableChanged().setVarName("historymapids"));
/* 420 */     lb.add(new ListenableChanged().setVarName("paradeindex"));
/* 421 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FlowerParadeHistory {
/*     */     private Const() {}
/*     */     
/*     */     FlowerParadeHistory nThis() {
/* 428 */       return FlowerParadeHistory.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory copy()
/*     */     {
/* 440 */       return FlowerParadeHistory.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory toData()
/*     */     {
/* 446 */       return FlowerParadeHistory.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FlowerParadeHistory toBean()
/*     */     {
/* 451 */       return FlowerParadeHistory.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory toDataIf()
/*     */     {
/* 457 */       return FlowerParadeHistory.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FlowerParadeHistory toBeanIf()
/*     */     {
/* 462 */       return FlowerParadeHistory.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getHistoryroles()
/*     */     {
/* 469 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 470 */       return xdb.Consts.constList(FlowerParadeHistory.this.historyroles);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getHistoryrolesAsData()
/*     */     {
/* 476 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/*     */       
/* 478 */       FlowerParadeHistory _o_ = FlowerParadeHistory.this;
/* 479 */       List<Long> historyroles = new ArrayList();
/* 480 */       historyroles.addAll(_o_.historyroles);
/* 481 */       return historyroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistoryocpids()
/*     */     {
/* 488 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 489 */       return xdb.Consts.constList(FlowerParadeHistory.this.historyocpids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getHistoryocpidsAsData()
/*     */     {
/* 495 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/*     */       
/* 497 */       FlowerParadeHistory _o_ = FlowerParadeHistory.this;
/* 498 */       List<Integer> historyocpids = new ArrayList();
/* 499 */       historyocpids.addAll(_o_.historyocpids);
/* 500 */       return historyocpids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistorymapids()
/*     */     {
/* 507 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 508 */       return xdb.Consts.constList(FlowerParadeHistory.this.historymapids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getHistorymapidsAsData()
/*     */     {
/* 514 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/*     */       
/* 516 */       FlowerParadeHistory _o_ = FlowerParadeHistory.this;
/* 517 */       List<Integer> historymapids = new ArrayList();
/* 518 */       historymapids.addAll(_o_.historymapids);
/* 519 */       return historymapids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getParadeindex()
/*     */     {
/* 526 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 527 */       return FlowerParadeHistory.this.paradeindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setParadeindex(long _v_)
/*     */     {
/* 534 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 535 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 541 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 542 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 548 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 549 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 555 */       return FlowerParadeHistory.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 561 */       return FlowerParadeHistory.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 567 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 568 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 574 */       return FlowerParadeHistory.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 580 */       return FlowerParadeHistory.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 586 */       FlowerParadeHistory.this._xdb_verify_unsafe_();
/* 587 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 593 */       return FlowerParadeHistory.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 599 */       return FlowerParadeHistory.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 605 */       return FlowerParadeHistory.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 611 */       return FlowerParadeHistory.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 617 */       return FlowerParadeHistory.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 623 */       return FlowerParadeHistory.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 629 */       return FlowerParadeHistory.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FlowerParadeHistory
/*     */   {
/*     */     private ArrayList<Long> historyroles;
/*     */     
/*     */     private ArrayList<Integer> historyocpids;
/*     */     
/*     */     private ArrayList<Integer> historymapids;
/*     */     
/*     */     private long paradeindex;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 647 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 652 */       this.historyroles = new ArrayList();
/* 653 */       this.historyocpids = new ArrayList();
/* 654 */       this.historymapids = new ArrayList();
/* 655 */       this.paradeindex = 0L;
/*     */     }
/*     */     
/*     */     Data(xbean.FlowerParadeHistory _o1_)
/*     */     {
/* 660 */       if ((_o1_ instanceof FlowerParadeHistory)) { assign((FlowerParadeHistory)_o1_);
/* 661 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 662 */       } else if ((_o1_ instanceof FlowerParadeHistory.Const)) assign(((FlowerParadeHistory.Const)_o1_).nThis()); else {
/* 663 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FlowerParadeHistory _o_) {
/* 668 */       this.historyroles = new ArrayList();
/* 669 */       this.historyroles.addAll(_o_.historyroles);
/* 670 */       this.historyocpids = new ArrayList();
/* 671 */       this.historyocpids.addAll(_o_.historyocpids);
/* 672 */       this.historymapids = new ArrayList();
/* 673 */       this.historymapids.addAll(_o_.historymapids);
/* 674 */       this.paradeindex = _o_.paradeindex;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 679 */       this.historyroles = new ArrayList();
/* 680 */       this.historyroles.addAll(_o_.historyroles);
/* 681 */       this.historyocpids = new ArrayList();
/* 682 */       this.historyocpids.addAll(_o_.historyocpids);
/* 683 */       this.historymapids = new ArrayList();
/* 684 */       this.historymapids.addAll(_o_.historymapids);
/* 685 */       this.paradeindex = _o_.paradeindex;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 691 */       _os_.compact_uint32(this.historyroles.size());
/* 692 */       for (Long _v_ : this.historyroles)
/*     */       {
/* 694 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 696 */       _os_.compact_uint32(this.historyocpids.size());
/* 697 */       for (Integer _v_ : this.historyocpids)
/*     */       {
/* 699 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 701 */       _os_.compact_uint32(this.historymapids.size());
/* 702 */       for (Integer _v_ : this.historymapids)
/*     */       {
/* 704 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 706 */       _os_.marshal(this.paradeindex);
/* 707 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 713 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 715 */         long _v_ = 0L;
/* 716 */         _v_ = _os_.unmarshal_long();
/* 717 */         this.historyroles.add(Long.valueOf(_v_));
/*     */       }
/* 719 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 721 */         int _v_ = 0;
/* 722 */         _v_ = _os_.unmarshal_int();
/* 723 */         this.historyocpids.add(Integer.valueOf(_v_));
/*     */       }
/* 725 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 727 */         int _v_ = 0;
/* 728 */         _v_ = _os_.unmarshal_int();
/* 729 */         this.historymapids.add(Integer.valueOf(_v_));
/*     */       }
/* 731 */       this.paradeindex = _os_.unmarshal_long();
/* 732 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 738 */       int _size_ = 0;
/* 739 */       for (Long _v_ : this.historyroles)
/*     */       {
/* 741 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 743 */       for (Integer _v_ : this.historyocpids)
/*     */       {
/* 745 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 747 */       for (Integer _v_ : this.historymapids)
/*     */       {
/* 749 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 751 */       _size_ += CodedOutputStream.computeInt64Size(4, this.paradeindex);
/* 752 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 760 */         for (Long _v_ : this.historyroles)
/*     */         {
/* 762 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/* 764 */         for (Integer _v_ : this.historyocpids)
/*     */         {
/* 766 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 768 */         for (Integer _v_ : this.historymapids)
/*     */         {
/* 770 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/* 772 */         _output_.writeInt64(4, this.paradeindex);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 776 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 778 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 786 */         boolean done = false;
/* 787 */         while (!done)
/*     */         {
/* 789 */           int tag = _input_.readTag();
/* 790 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 794 */             done = true;
/* 795 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 799 */             long _v_ = 0L;
/* 800 */             _v_ = _input_.readInt64();
/* 801 */             this.historyroles.add(Long.valueOf(_v_));
/* 802 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 806 */             int _v_ = 0;
/* 807 */             _v_ = _input_.readInt32();
/* 808 */             this.historyocpids.add(Integer.valueOf(_v_));
/* 809 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 813 */             int _v_ = 0;
/* 814 */             _v_ = _input_.readInt32();
/* 815 */             this.historymapids.add(Integer.valueOf(_v_));
/* 816 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 820 */             this.paradeindex = _input_.readInt64();
/* 821 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 825 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 827 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 836 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 840 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 842 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory copy()
/*     */     {
/* 848 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory toData()
/*     */     {
/* 854 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FlowerParadeHistory toBean()
/*     */     {
/* 859 */       return new FlowerParadeHistory(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FlowerParadeHistory toDataIf()
/*     */     {
/* 865 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FlowerParadeHistory toBeanIf()
/*     */     {
/* 870 */       return new FlowerParadeHistory(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 876 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 880 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 884 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 888 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 892 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 896 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 900 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getHistoryroles()
/*     */     {
/* 907 */       return this.historyroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getHistoryrolesAsData()
/*     */     {
/* 914 */       return this.historyroles;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistoryocpids()
/*     */     {
/* 921 */       return this.historyocpids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistoryocpidsAsData()
/*     */     {
/* 928 */       return this.historyocpids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistorymapids()
/*     */     {
/* 935 */       return this.historymapids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getHistorymapidsAsData()
/*     */     {
/* 942 */       return this.historymapids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getParadeindex()
/*     */     {
/* 949 */       return this.paradeindex;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setParadeindex(long _v_)
/*     */     {
/* 956 */       this.paradeindex = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 962 */       if (!(_o1_ instanceof Data)) return false;
/* 963 */       Data _o_ = (Data)_o1_;
/* 964 */       if (!this.historyroles.equals(_o_.historyroles)) return false;
/* 965 */       if (!this.historyocpids.equals(_o_.historyocpids)) return false;
/* 966 */       if (!this.historymapids.equals(_o_.historymapids)) return false;
/* 967 */       if (this.paradeindex != _o_.paradeindex) return false;
/* 968 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 974 */       int _h_ = 0;
/* 975 */       _h_ += this.historyroles.hashCode();
/* 976 */       _h_ += this.historyocpids.hashCode();
/* 977 */       _h_ += this.historymapids.hashCode();
/* 978 */       _h_ = (int)(_h_ + this.paradeindex);
/* 979 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 985 */       StringBuilder _sb_ = new StringBuilder();
/* 986 */       _sb_.append("(");
/* 987 */       _sb_.append(this.historyroles);
/* 988 */       _sb_.append(",");
/* 989 */       _sb_.append(this.historyocpids);
/* 990 */       _sb_.append(",");
/* 991 */       _sb_.append(this.historymapids);
/* 992 */       _sb_.append(",");
/* 993 */       _sb_.append(this.paradeindex);
/* 994 */       _sb_.append(")");
/* 995 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FlowerParadeHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */