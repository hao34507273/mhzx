/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.TreeMap;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ 
/*     */ public final class CrossLadderSeasonRankBackup extends xdb.XBean implements xbean.CrossLadderSeasonRankBackup
/*     */ {
/*     */   private TreeMap<Integer, xbean.CrossLadderLevelRangeRankBackup> level_range_rank_backups;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.level_range_rank_backups.clear();
/*     */   }
/*     */   
/*     */   CrossLadderSeasonRankBackup(int __, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.level_range_rank_backups = new TreeMap();
/*     */   }
/*     */   
/*     */   public CrossLadderSeasonRankBackup()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CrossLadderSeasonRankBackup(CrossLadderSeasonRankBackup _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CrossLadderSeasonRankBackup(xbean.CrossLadderSeasonRankBackup _o1_, xdb.XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof CrossLadderSeasonRankBackup)) { assign((CrossLadderSeasonRankBackup)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CrossLadderSeasonRankBackup _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.level_range_rank_backups = new TreeMap();
/*  50 */     for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet()) {
/*  51 */       this.level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue(), this, "level_range_rank_backups"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.level_range_rank_backups = new TreeMap();
/*  57 */     for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet()) {
/*  58 */       this.level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue(), this, "level_range_rank_backups"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.level_range_rank_backups.size());
/*  66 */     for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */     {
/*  68 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  69 */       ((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()).marshal(_os_);
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  77 */     _xdb_verify_unsafe_();
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = 0;
/*  81 */       _k_ = _os_.unmarshal_int();
/*  82 */       xbean.CrossLadderLevelRangeRankBackup _v_ = new CrossLadderLevelRangeRankBackup(0, this, "level_range_rank_backups");
/*  83 */       _v_.unmarshal(_os_);
/*  84 */       this.level_range_rank_backups.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */     {
/*  96 */       _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/*  97 */       _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */     }
/*  99 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 105 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 108 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */       {
/* 110 */         _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 111 */         _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 116 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 118 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 124 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 127 */       boolean done = false;
/* 128 */       while (!done)
/*     */       {
/* 130 */         int tag = _input_.readTag();
/* 131 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 135 */           done = true;
/* 136 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 140 */           int _k_ = 0;
/* 141 */           _k_ = _input_.readInt32();
/* 142 */           int readTag = _input_.readTag();
/* 143 */           if (10 != readTag)
/*     */           {
/* 145 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 147 */           xbean.CrossLadderLevelRangeRankBackup _v_ = new CrossLadderLevelRangeRankBackup(0, this, "level_range_rank_backups");
/* 148 */           _input_.readMessage(_v_);
/* 149 */           this.level_range_rank_backups.put(Integer.valueOf(_k_), _v_);
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderSeasonRankBackup copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new CrossLadderSeasonRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderSeasonRankBackup toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderSeasonRankBackup toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new CrossLadderSeasonRankBackup(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CrossLadderSeasonRankBackup toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CrossLadderSeasonRankBackup toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backups()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return xdb.Logs.logNavigableMap(new xdb.LogKey(this, "level_range_rank_backups"), this.level_range_rank_backups);
/*     */   }
/*     */   
/*     */ 
/*     */   public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backupsAsData()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/*     */     
/* 227 */     CrossLadderSeasonRankBackup _o_ = this;
/* 228 */     NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> level_range_rank_backups = new TreeMap();
/* 229 */     for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet())
/* 230 */       level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup.Data((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()));
/* 231 */     return level_range_rank_backups;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     CrossLadderSeasonRankBackup _o_ = null;
/* 239 */     if ((_o1_ instanceof CrossLadderSeasonRankBackup)) { _o_ = (CrossLadderSeasonRankBackup)_o1_;
/* 240 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 241 */       return false;
/* 242 */     if (!this.level_range_rank_backups.equals(_o_.level_range_rank_backups)) return false;
/* 243 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 249 */     _xdb_verify_unsafe_();
/* 250 */     int _h_ = 0;
/* 251 */     _h_ += this.level_range_rank_backups.hashCode();
/* 252 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     StringBuilder _sb_ = new StringBuilder();
/* 260 */     _sb_.append("(");
/* 261 */     _sb_.append(this.level_range_rank_backups);
/* 262 */     _sb_.append(")");
/* 263 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 269 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 270 */     lb.add(new xdb.logs.ListenableMap().setVarName("level_range_rank_backups"));
/* 271 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CrossLadderSeasonRankBackup {
/*     */     private Const() {}
/*     */     
/*     */     CrossLadderSeasonRankBackup nThis() {
/* 278 */       return CrossLadderSeasonRankBackup.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 284 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup copy()
/*     */     {
/* 290 */       return CrossLadderSeasonRankBackup.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup toData()
/*     */     {
/* 296 */       return CrossLadderSeasonRankBackup.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderSeasonRankBackup toBean()
/*     */     {
/* 301 */       return CrossLadderSeasonRankBackup.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup toDataIf()
/*     */     {
/* 307 */       return CrossLadderSeasonRankBackup.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderSeasonRankBackup toBeanIf()
/*     */     {
/* 312 */       return CrossLadderSeasonRankBackup.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backups()
/*     */     {
/* 319 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/* 320 */       return xdb.Consts.constNavigableMap(CrossLadderSeasonRankBackup.this.level_range_rank_backups);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backupsAsData()
/*     */     {
/* 327 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/*     */       
/* 329 */       CrossLadderSeasonRankBackup _o_ = CrossLadderSeasonRankBackup.this;
/* 330 */       NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> level_range_rank_backups = new TreeMap();
/* 331 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet())
/* 332 */         level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup.Data((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()));
/* 333 */       return level_range_rank_backups;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 339 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/* 340 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 346 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/* 347 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 353 */       return CrossLadderSeasonRankBackup.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 359 */       return CrossLadderSeasonRankBackup.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 365 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/* 366 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 372 */       return CrossLadderSeasonRankBackup.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 378 */       return CrossLadderSeasonRankBackup.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 384 */       CrossLadderSeasonRankBackup.this._xdb_verify_unsafe_();
/* 385 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 391 */       return CrossLadderSeasonRankBackup.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 397 */       return CrossLadderSeasonRankBackup.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 403 */       return CrossLadderSeasonRankBackup.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 409 */       return CrossLadderSeasonRankBackup.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 415 */       return CrossLadderSeasonRankBackup.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 421 */       return CrossLadderSeasonRankBackup.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 427 */       return CrossLadderSeasonRankBackup.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CrossLadderSeasonRankBackup
/*     */   {
/*     */     private TreeMap<Integer, xbean.CrossLadderLevelRangeRankBackup> level_range_rank_backups;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 439 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 444 */       this.level_range_rank_backups = new TreeMap();
/*     */     }
/*     */     
/*     */     Data(xbean.CrossLadderSeasonRankBackup _o1_)
/*     */     {
/* 449 */       if ((_o1_ instanceof CrossLadderSeasonRankBackup)) { assign((CrossLadderSeasonRankBackup)_o1_);
/* 450 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 451 */       } else if ((_o1_ instanceof CrossLadderSeasonRankBackup.Const)) assign(((CrossLadderSeasonRankBackup.Const)_o1_).nThis()); else {
/* 452 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CrossLadderSeasonRankBackup _o_) {
/* 457 */       this.level_range_rank_backups = new TreeMap();
/* 458 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet()) {
/* 459 */         this.level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup.Data((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 464 */       this.level_range_rank_backups = new TreeMap();
/* 465 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : _o_.level_range_rank_backups.entrySet()) {
/* 466 */         this.level_range_rank_backups.put(_e_.getKey(), new CrossLadderLevelRangeRankBackup.Data((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 472 */       _os_.compact_uint32(this.level_range_rank_backups.size());
/* 473 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */       {
/* 475 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 476 */         ((xbean.CrossLadderLevelRangeRankBackup)_e_.getValue()).marshal(_os_);
/*     */       }
/* 478 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 484 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 486 */         int _k_ = 0;
/* 487 */         _k_ = _os_.unmarshal_int();
/* 488 */         xbean.CrossLadderLevelRangeRankBackup _v_ = xbean.Pod.newCrossLadderLevelRangeRankBackupData();
/* 489 */         _v_.unmarshal(_os_);
/* 490 */         this.level_range_rank_backups.put(Integer.valueOf(_k_), _v_);
/*     */       }
/* 492 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 498 */       int _size_ = 0;
/* 499 */       for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */       {
/* 501 */         _size_ += CodedOutputStream.computeInt32Size(1, ((Integer)_e_.getKey()).intValue());
/* 502 */         _size_ += CodedOutputStream.computeMessageSize(1, (ppbio.Message)_e_.getValue());
/*     */       }
/* 504 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 512 */         for (Map.Entry<Integer, xbean.CrossLadderLevelRangeRankBackup> _e_ : this.level_range_rank_backups.entrySet())
/*     */         {
/* 514 */           _output_.writeInt32(1, ((Integer)_e_.getKey()).intValue());
/* 515 */           _output_.writeMessage(1, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 520 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 522 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 530 */         boolean done = false;
/* 531 */         while (!done)
/*     */         {
/* 533 */           int tag = _input_.readTag();
/* 534 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 538 */             done = true;
/* 539 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 543 */             int _k_ = 0;
/* 544 */             _k_ = _input_.readInt32();
/* 545 */             int readTag = _input_.readTag();
/* 546 */             if (10 != readTag)
/*     */             {
/* 548 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 550 */             xbean.CrossLadderLevelRangeRankBackup _v_ = xbean.Pod.newCrossLadderLevelRangeRankBackupData();
/* 551 */             _input_.readMessage(_v_);
/* 552 */             this.level_range_rank_backups.put(Integer.valueOf(_k_), _v_);
/* 553 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 557 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 559 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 568 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 572 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 574 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup copy()
/*     */     {
/* 580 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup toData()
/*     */     {
/* 586 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderSeasonRankBackup toBean()
/*     */     {
/* 591 */       return new CrossLadderSeasonRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CrossLadderSeasonRankBackup toDataIf()
/*     */     {
/* 597 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CrossLadderSeasonRankBackup toBeanIf()
/*     */     {
/* 602 */       return new CrossLadderSeasonRankBackup(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 608 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 612 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 616 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 620 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 624 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 628 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 632 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backups()
/*     */     {
/* 639 */       return this.level_range_rank_backups;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public NavigableMap<Integer, xbean.CrossLadderLevelRangeRankBackup> getLevel_range_rank_backupsAsData()
/*     */     {
/* 646 */       return this.level_range_rank_backups;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 652 */       if (!(_o1_ instanceof Data)) return false;
/* 653 */       Data _o_ = (Data)_o1_;
/* 654 */       if (!this.level_range_rank_backups.equals(_o_.level_range_rank_backups)) return false;
/* 655 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 661 */       int _h_ = 0;
/* 662 */       _h_ += this.level_range_rank_backups.hashCode();
/* 663 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 669 */       StringBuilder _sb_ = new StringBuilder();
/* 670 */       _sb_.append("(");
/* 671 */       _sb_.append(this.level_range_rank_backups);
/* 672 */       _sb_.append(")");
/* 673 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossLadderSeasonRankBackup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */