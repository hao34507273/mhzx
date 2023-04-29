/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.musicgame.event.MusicGameContext;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.Logs;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class MusicGameInfo extends XBean implements xbean.MusicGameInfo
/*     */ {
/*     */   private int game_state;
/*     */   private int complete_turn_index;
/*     */   private int right_turn_num;
/*     */   private long sessionid;
/*     */   private long start_timestamp;
/*     */   private MusicGameContext context;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  28 */     this.game_state = 2;
/*  29 */     this.complete_turn_index = 0;
/*  30 */     this.right_turn_num = 0;
/*  31 */     this.sessionid = -1L;
/*  32 */     this.start_timestamp = -1L;
/*  33 */     this.context = null;
/*     */   }
/*     */   
/*     */   MusicGameInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     this.game_state = 2;
/*  40 */     this.complete_turn_index = 0;
/*  41 */     this.right_turn_num = 0;
/*  42 */     this.sessionid = -1L;
/*  43 */     this.start_timestamp = -1L;
/*  44 */     this.context = null;
/*     */   }
/*     */   
/*     */   public MusicGameInfo()
/*     */   {
/*  49 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MusicGameInfo(MusicGameInfo _o_)
/*     */   {
/*  54 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MusicGameInfo(xbean.MusicGameInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  59 */     super(_xp_, _vn_);
/*  60 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  66 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  72 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  78 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  90 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MusicGameInfo copy()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     return new MusicGameInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MusicGameInfo toData()
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/* 104 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MusicGameInfo toBean()
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/* 110 */     return new MusicGameInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MusicGameInfo toDataIf()
/*     */   {
/* 116 */     _xdb_verify_unsafe_();
/* 117 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MusicGameInfo toBeanIf()
/*     */   {
/* 122 */     _xdb_verify_unsafe_();
/* 123 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 129 */     _xdb_verify_unsafe_();
/* 130 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGame_state()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     return this.game_state;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getComplete_turn_index()
/*     */   {
/* 145 */     _xdb_verify_unsafe_();
/* 146 */     return this.complete_turn_index;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRight_turn_num()
/*     */   {
/* 153 */     _xdb_verify_unsafe_();
/* 154 */     return this.right_turn_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSessionid()
/*     */   {
/* 161 */     _xdb_verify_unsafe_();
/* 162 */     return this.sessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_timestamp()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return this.start_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public MusicGameContext getContext()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return this.context;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGame_state(int _v_)
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     Logs.logIf(new LogKey(this, "game_state")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 190 */         new LogInt(this, MusicGameInfo.this.game_state)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 194 */             MusicGameInfo.this.game_state = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 198 */     });
/* 199 */     this.game_state = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setComplete_turn_index(int _v_)
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     Logs.logIf(new LogKey(this, "complete_turn_index")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 211 */         new LogInt(this, MusicGameInfo.this.complete_turn_index)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 215 */             MusicGameInfo.this.complete_turn_index = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 219 */     });
/* 220 */     this.complete_turn_index = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRight_turn_num(int _v_)
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     Logs.logIf(new LogKey(this, "right_turn_num")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 232 */         new LogInt(this, MusicGameInfo.this.right_turn_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 236 */             MusicGameInfo.this.right_turn_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 240 */     });
/* 241 */     this.right_turn_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSessionid(long _v_)
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     Logs.logIf(new LogKey(this, "sessionid")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 253 */         new xdb.logs.LogLong(this, MusicGameInfo.this.sessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 257 */             MusicGameInfo.this.sessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 261 */     });
/* 262 */     this.sessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_timestamp(long _v_)
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     Logs.logIf(new LogKey(this, "start_timestamp")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 274 */         new xdb.logs.LogLong(this, MusicGameInfo.this.start_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 278 */             MusicGameInfo.this.start_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 282 */     });
/* 283 */     this.start_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setContext(MusicGameContext _v_)
/*     */   {
/* 290 */     _xdb_verify_unsafe_();
/* 291 */     Logs.logIf(new LogKey(this, "context")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 295 */         new xdb.logs.LogObject(this, MusicGameInfo.this.context)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 299 */             MusicGameInfo.this.context = ((MusicGameContext)this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 303 */     });
/* 304 */     this.context = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 310 */     _xdb_verify_unsafe_();
/* 311 */     MusicGameInfo _o_ = null;
/* 312 */     if ((_o1_ instanceof MusicGameInfo)) { _o_ = (MusicGameInfo)_o1_;
/* 313 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 314 */       return false;
/* 315 */     if (this.game_state != _o_.game_state) return false;
/* 316 */     if (this.complete_turn_index != _o_.complete_turn_index) return false;
/* 317 */     if (this.right_turn_num != _o_.right_turn_num) return false;
/* 318 */     if (this.sessionid != _o_.sessionid) return false;
/* 319 */     if (this.start_timestamp != _o_.start_timestamp) return false;
/* 320 */     if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 321 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 327 */     _xdb_verify_unsafe_();
/* 328 */     int _h_ = 0;
/* 329 */     _h_ += this.game_state;
/* 330 */     _h_ += this.complete_turn_index;
/* 331 */     _h_ += this.right_turn_num;
/* 332 */     _h_ = (int)(_h_ + this.sessionid);
/* 333 */     _h_ = (int)(_h_ + this.start_timestamp);
/* 334 */     _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 335 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     StringBuilder _sb_ = new StringBuilder();
/* 343 */     _sb_.append("(");
/* 344 */     _sb_.append(this.game_state);
/* 345 */     _sb_.append(",");
/* 346 */     _sb_.append(this.complete_turn_index);
/* 347 */     _sb_.append(",");
/* 348 */     _sb_.append(this.right_turn_num);
/* 349 */     _sb_.append(",");
/* 350 */     _sb_.append(this.sessionid);
/* 351 */     _sb_.append(",");
/* 352 */     _sb_.append(this.start_timestamp);
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.context);
/* 355 */     _sb_.append(")");
/* 356 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 362 */     ListenableBean lb = new ListenableBean();
/* 363 */     lb.add(new ListenableChanged().setVarName("game_state"));
/* 364 */     lb.add(new ListenableChanged().setVarName("complete_turn_index"));
/* 365 */     lb.add(new ListenableChanged().setVarName("right_turn_num"));
/* 366 */     lb.add(new ListenableChanged().setVarName("sessionid"));
/* 367 */     lb.add(new ListenableChanged().setVarName("start_timestamp"));
/* 368 */     lb.add(new ListenableChanged().setVarName("context"));
/* 369 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MusicGameInfo {
/*     */     private Const() {}
/*     */     
/*     */     MusicGameInfo nThis() {
/* 376 */       return MusicGameInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 382 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo copy()
/*     */     {
/* 388 */       return MusicGameInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo toData()
/*     */     {
/* 394 */       return MusicGameInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MusicGameInfo toBean()
/*     */     {
/* 399 */       return MusicGameInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo toDataIf()
/*     */     {
/* 405 */       return MusicGameInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MusicGameInfo toBeanIf()
/*     */     {
/* 410 */       return MusicGameInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGame_state()
/*     */     {
/* 417 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 418 */       return MusicGameInfo.this.game_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getComplete_turn_index()
/*     */     {
/* 425 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 426 */       return MusicGameInfo.this.complete_turn_index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRight_turn_num()
/*     */     {
/* 433 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 434 */       return MusicGameInfo.this.right_turn_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 441 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 442 */       return MusicGameInfo.this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_timestamp()
/*     */     {
/* 449 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 450 */       return MusicGameInfo.this.start_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public MusicGameContext getContext()
/*     */     {
/* 457 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 458 */       return MusicGameInfo.this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGame_state(int _v_)
/*     */     {
/* 465 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 466 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setComplete_turn_index(int _v_)
/*     */     {
/* 473 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 474 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRight_turn_num(int _v_)
/*     */     {
/* 481 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 482 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 489 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 490 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_timestamp(long _v_)
/*     */     {
/* 497 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 498 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(MusicGameContext _v_)
/*     */     {
/* 505 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 512 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 513 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 519 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 520 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 526 */       return MusicGameInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 532 */       return MusicGameInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 538 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 539 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 545 */       return MusicGameInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 551 */       return MusicGameInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 557 */       MusicGameInfo.this._xdb_verify_unsafe_();
/* 558 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 564 */       return MusicGameInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 570 */       return MusicGameInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 576 */       return MusicGameInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 582 */       return MusicGameInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 588 */       return MusicGameInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 594 */       return MusicGameInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 600 */       return MusicGameInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MusicGameInfo
/*     */   {
/*     */     private int game_state;
/*     */     
/*     */     private int complete_turn_index;
/*     */     
/*     */     private int right_turn_num;
/*     */     
/*     */     private long sessionid;
/*     */     
/*     */     private long start_timestamp;
/*     */     
/*     */     private MusicGameContext context;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 622 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 627 */       this.game_state = 2;
/* 628 */       this.complete_turn_index = 0;
/* 629 */       this.right_turn_num = 0;
/* 630 */       this.sessionid = -1L;
/* 631 */       this.start_timestamp = -1L;
/* 632 */       this.context = null;
/*     */     }
/*     */     
/*     */     Data(xbean.MusicGameInfo _o1_)
/*     */     {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 649 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 655 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 661 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 667 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo copy()
/*     */     {
/* 673 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo toData()
/*     */     {
/* 679 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MusicGameInfo toBean()
/*     */     {
/* 684 */       return new MusicGameInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MusicGameInfo toDataIf()
/*     */     {
/* 690 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MusicGameInfo toBeanIf()
/*     */     {
/* 695 */       return new MusicGameInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 701 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 705 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 709 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 713 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 717 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 721 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 725 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGame_state()
/*     */     {
/* 732 */       return this.game_state;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getComplete_turn_index()
/*     */     {
/* 739 */       return this.complete_turn_index;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRight_turn_num()
/*     */     {
/* 746 */       return this.right_turn_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSessionid()
/*     */     {
/* 753 */       return this.sessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_timestamp()
/*     */     {
/* 760 */       return this.start_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public MusicGameContext getContext()
/*     */     {
/* 767 */       return this.context;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGame_state(int _v_)
/*     */     {
/* 774 */       this.game_state = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setComplete_turn_index(int _v_)
/*     */     {
/* 781 */       this.complete_turn_index = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRight_turn_num(int _v_)
/*     */     {
/* 788 */       this.right_turn_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSessionid(long _v_)
/*     */     {
/* 795 */       this.sessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_timestamp(long _v_)
/*     */     {
/* 802 */       this.start_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setContext(MusicGameContext _v_)
/*     */     {
/* 809 */       this.context = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 815 */       if (!(_o1_ instanceof Data)) return false;
/* 816 */       Data _o_ = (Data)_o1_;
/* 817 */       if (this.game_state != _o_.game_state) return false;
/* 818 */       if (this.complete_turn_index != _o_.complete_turn_index) return false;
/* 819 */       if (this.right_turn_num != _o_.right_turn_num) return false;
/* 820 */       if (this.sessionid != _o_.sessionid) return false;
/* 821 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/* 822 */       if (((null == this.context) && (null != _o_.context)) || ((null != this.context) && (null == _o_.context)) || ((null != this.context) && (null != _o_.context) && (!this.context.equals(_o_.context)))) return false;
/* 823 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 829 */       int _h_ = 0;
/* 830 */       _h_ += this.game_state;
/* 831 */       _h_ += this.complete_turn_index;
/* 832 */       _h_ += this.right_turn_num;
/* 833 */       _h_ = (int)(_h_ + this.sessionid);
/* 834 */       _h_ = (int)(_h_ + this.start_timestamp);
/* 835 */       _h_ += (this.context == null ? 0 : this.context.hashCode());
/* 836 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 842 */       StringBuilder _sb_ = new StringBuilder();
/* 843 */       _sb_.append("(");
/* 844 */       _sb_.append(this.game_state);
/* 845 */       _sb_.append(",");
/* 846 */       _sb_.append(this.complete_turn_index);
/* 847 */       _sb_.append(",");
/* 848 */       _sb_.append(this.right_turn_num);
/* 849 */       _sb_.append(",");
/* 850 */       _sb_.append(this.sessionid);
/* 851 */       _sb_.append(",");
/* 852 */       _sb_.append(this.start_timestamp);
/* 853 */       _sb_.append(",");
/* 854 */       _sb_.append(this.context);
/* 855 */       _sb_.append(")");
/* 856 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MusicGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */