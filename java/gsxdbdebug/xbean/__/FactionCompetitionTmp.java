/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class FactionCompetitionTmp extends XBean implements xbean.FactionCompetitionTmp
/*     */ {
/*     */   private long world;
/*     */   private int player_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.world = -1L;
/*  21 */     this.player_num = 0;
/*     */   }
/*     */   
/*     */   FactionCompetitionTmp(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.world = -1L;
/*  28 */     this.player_num = 0;
/*     */   }
/*     */   
/*     */   public FactionCompetitionTmp()
/*     */   {
/*  33 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FactionCompetitionTmp(FactionCompetitionTmp _o_)
/*     */   {
/*  38 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FactionCompetitionTmp(xbean.FactionCompetitionTmp _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  43 */     super(_xp_, _vn_);
/*  44 */     if ((_o1_ instanceof FactionCompetitionTmp)) { assign((FactionCompetitionTmp)_o1_);
/*  45 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  46 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  47 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FactionCompetitionTmp _o_) {
/*  52 */     _o_._xdb_verify_unsafe_();
/*  53 */     this.world = _o_.world;
/*  54 */     this.player_num = _o_.player_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.world = _o_.world;
/*  60 */     this.player_num = _o_.player_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     _xdb_verify_unsafe_();
/*  67 */     _os_.marshal(this.world);
/*  68 */     _os_.marshal(this.player_num);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     this.world = _os_.unmarshal_long();
/*  77 */     this.player_num = _os_.unmarshal_int();
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*  85 */     int _size_ = 0;
/*  86 */     _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/*  87 */     _size_ += CodedOutputStream.computeInt32Size(2, this.player_num);
/*  88 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  97 */       _output_.writeInt64(1, this.world);
/*  98 */       _output_.writeInt32(2, this.player_num);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 102 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 104 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 110 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 113 */       boolean done = false;
/* 114 */       while (!done)
/*     */       {
/* 116 */         int tag = _input_.readTag();
/* 117 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 121 */           done = true;
/* 122 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 126 */           this.world = _input_.readInt64();
/* 127 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 131 */           this.player_num = _input_.readInt32();
/* 132 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 136 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 138 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 147 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 151 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 153 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCompetitionTmp copy()
/*     */   {
/* 159 */     _xdb_verify_unsafe_();
/* 160 */     return new FactionCompetitionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCompetitionTmp toData()
/*     */   {
/* 166 */     _xdb_verify_unsafe_();
/* 167 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionCompetitionTmp toBean()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new FactionCompetitionTmp(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionCompetitionTmp toDataIf()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionCompetitionTmp toBeanIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getWorld()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this.world;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPlayer_num()
/*     */   {
/* 208 */     _xdb_verify_unsafe_();
/* 209 */     return this.player_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorld(long _v_)
/*     */   {
/* 216 */     _xdb_verify_unsafe_();
/* 217 */     xdb.Logs.logIf(new LogKey(this, "world")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 221 */         new xdb.logs.LogLong(this, FactionCompetitionTmp.this.world)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 225 */             FactionCompetitionTmp.this.world = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 229 */     });
/* 230 */     this.world = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPlayer_num(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "player_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogInt(this, FactionCompetitionTmp.this.player_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             FactionCompetitionTmp.this.player_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.player_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     FactionCompetitionTmp _o_ = null;
/* 259 */     if ((_o1_ instanceof FactionCompetitionTmp)) { _o_ = (FactionCompetitionTmp)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (this.world != _o_.world) return false;
/* 263 */     if (this.player_num != _o_.player_num) return false;
/* 264 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 270 */     _xdb_verify_unsafe_();
/* 271 */     int _h_ = 0;
/* 272 */     _h_ = (int)(_h_ + this.world);
/* 273 */     _h_ += this.player_num;
/* 274 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     StringBuilder _sb_ = new StringBuilder();
/* 282 */     _sb_.append("(");
/* 283 */     _sb_.append(this.world);
/* 284 */     _sb_.append(",");
/* 285 */     _sb_.append(this.player_num);
/* 286 */     _sb_.append(")");
/* 287 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 293 */     ListenableBean lb = new ListenableBean();
/* 294 */     lb.add(new xdb.logs.ListenableChanged().setVarName("world"));
/* 295 */     lb.add(new xdb.logs.ListenableChanged().setVarName("player_num"));
/* 296 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FactionCompetitionTmp {
/*     */     private Const() {}
/*     */     
/*     */     FactionCompetitionTmp nThis() {
/* 303 */       return FactionCompetitionTmp.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 309 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp copy()
/*     */     {
/* 315 */       return FactionCompetitionTmp.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp toData()
/*     */     {
/* 321 */       return FactionCompetitionTmp.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FactionCompetitionTmp toBean()
/*     */     {
/* 326 */       return FactionCompetitionTmp.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp toDataIf()
/*     */     {
/* 332 */       return FactionCompetitionTmp.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FactionCompetitionTmp toBeanIf()
/*     */     {
/* 337 */       return FactionCompetitionTmp.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 344 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 345 */       return FactionCompetitionTmp.this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPlayer_num()
/*     */     {
/* 352 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 353 */       return FactionCompetitionTmp.this.player_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 360 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 361 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlayer_num(int _v_)
/*     */     {
/* 368 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 369 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 375 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 376 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 382 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 383 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 389 */       return FactionCompetitionTmp.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 395 */       return FactionCompetitionTmp.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 401 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 402 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 408 */       return FactionCompetitionTmp.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 414 */       return FactionCompetitionTmp.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 420 */       FactionCompetitionTmp.this._xdb_verify_unsafe_();
/* 421 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 427 */       return FactionCompetitionTmp.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 433 */       return FactionCompetitionTmp.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 439 */       return FactionCompetitionTmp.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 445 */       return FactionCompetitionTmp.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 451 */       return FactionCompetitionTmp.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 457 */       return FactionCompetitionTmp.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 463 */       return FactionCompetitionTmp.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FactionCompetitionTmp
/*     */   {
/*     */     private long world;
/*     */     
/*     */     private int player_num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 482 */       this.world = -1L;
/* 483 */       this.player_num = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.FactionCompetitionTmp _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof FactionCompetitionTmp)) { assign((FactionCompetitionTmp)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof FactionCompetitionTmp.Const)) assign(((FactionCompetitionTmp.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FactionCompetitionTmp _o_) {
/* 496 */       this.world = _o_.world;
/* 497 */       this.player_num = _o_.player_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 502 */       this.world = _o_.world;
/* 503 */       this.player_num = _o_.player_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 509 */       _os_.marshal(this.world);
/* 510 */       _os_.marshal(this.player_num);
/* 511 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 517 */       this.world = _os_.unmarshal_long();
/* 518 */       this.player_num = _os_.unmarshal_int();
/* 519 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 525 */       int _size_ = 0;
/* 526 */       _size_ += CodedOutputStream.computeInt64Size(1, this.world);
/* 527 */       _size_ += CodedOutputStream.computeInt32Size(2, this.player_num);
/* 528 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 536 */         _output_.writeInt64(1, this.world);
/* 537 */         _output_.writeInt32(2, this.player_num);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 551 */         boolean done = false;
/* 552 */         while (!done)
/*     */         {
/* 554 */           int tag = _input_.readTag();
/* 555 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 559 */             done = true;
/* 560 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 564 */             this.world = _input_.readInt64();
/* 565 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 569 */             this.player_num = _input_.readInt32();
/* 570 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 574 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 576 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 585 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 589 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 591 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp copy()
/*     */     {
/* 597 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp toData()
/*     */     {
/* 603 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FactionCompetitionTmp toBean()
/*     */     {
/* 608 */       return new FactionCompetitionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionCompetitionTmp toDataIf()
/*     */     {
/* 614 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FactionCompetitionTmp toBeanIf()
/*     */     {
/* 619 */       return new FactionCompetitionTmp(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 641 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 645 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 649 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorld()
/*     */     {
/* 656 */       return this.world;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPlayer_num()
/*     */     {
/* 663 */       return this.player_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorld(long _v_)
/*     */     {
/* 670 */       this.world = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPlayer_num(int _v_)
/*     */     {
/* 677 */       this.player_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 683 */       if (!(_o1_ instanceof Data)) return false;
/* 684 */       Data _o_ = (Data)_o1_;
/* 685 */       if (this.world != _o_.world) return false;
/* 686 */       if (this.player_num != _o_.player_num) return false;
/* 687 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 693 */       int _h_ = 0;
/* 694 */       _h_ = (int)(_h_ + this.world);
/* 695 */       _h_ += this.player_num;
/* 696 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 702 */       StringBuilder _sb_ = new StringBuilder();
/* 703 */       _sb_.append("(");
/* 704 */       _sb_.append(this.world);
/* 705 */       _sb_.append(",");
/* 706 */       _sb_.append(this.player_num);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionCompetitionTmp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */