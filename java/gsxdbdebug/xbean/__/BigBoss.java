/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class BigBoss extends XBean implements xbean.BigBoss
/*      */ {
/*      */   private int damagepoint;
/*      */   private int rank;
/*      */   private int buycount;
/*      */   private int restbuycount;
/*      */   private int challengecount;
/*      */   private int fightcount;
/*      */   private long starttime;
/*      */   private boolean isawarded;
/*      */   private boolean iskilledmonster;
/*      */   private int reserved;
/*      */   private HashMap<Integer, Integer> ocp2damagepoint;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   38 */     this.damagepoint = 0;
/*   39 */     this.rank = 0;
/*   40 */     this.buycount = 0;
/*   41 */     this.restbuycount = 0;
/*   42 */     this.challengecount = 0;
/*   43 */     this.fightcount = 0;
/*   44 */     this.starttime = 0L;
/*   45 */     this.isawarded = false;
/*   46 */     this.iskilledmonster = false;
/*   47 */     this.reserved = 0;
/*   48 */     this.ocp2damagepoint.clear();
/*      */   }
/*      */   
/*      */   BigBoss(int __, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     this.damagepoint = 0;
/*   55 */     this.rank = 0;
/*   56 */     this.buycount = 0;
/*   57 */     this.restbuycount = 0;
/*   58 */     this.challengecount = 0;
/*   59 */     this.fightcount = 0;
/*   60 */     this.starttime = 0L;
/*   61 */     this.isawarded = false;
/*   62 */     this.iskilledmonster = false;
/*   63 */     this.reserved = 0;
/*   64 */     this.ocp2damagepoint = new HashMap();
/*      */   }
/*      */   
/*      */   public BigBoss()
/*      */   {
/*   69 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BigBoss(BigBoss _o_)
/*      */   {
/*   74 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BigBoss(xbean.BigBoss _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   79 */     super(_xp_, _vn_);
/*   80 */     if ((_o1_ instanceof BigBoss)) { assign((BigBoss)_o1_);
/*   81 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   82 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   83 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BigBoss _o_) {
/*   88 */     _o_._xdb_verify_unsafe_();
/*   89 */     this.damagepoint = _o_.damagepoint;
/*   90 */     this.rank = _o_.rank;
/*   91 */     this.buycount = _o_.buycount;
/*   92 */     this.restbuycount = _o_.restbuycount;
/*   93 */     this.challengecount = _o_.challengecount;
/*   94 */     this.fightcount = _o_.fightcount;
/*   95 */     this.starttime = _o_.starttime;
/*   96 */     this.isawarded = _o_.isawarded;
/*   97 */     this.iskilledmonster = _o_.iskilledmonster;
/*   98 */     this.reserved = _o_.reserved;
/*   99 */     this.ocp2damagepoint = new HashMap();
/*  100 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet()) {
/*  101 */       this.ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*  106 */     this.damagepoint = _o_.damagepoint;
/*  107 */     this.rank = _o_.rank;
/*  108 */     this.buycount = _o_.buycount;
/*  109 */     this.restbuycount = _o_.restbuycount;
/*  110 */     this.challengecount = _o_.challengecount;
/*  111 */     this.fightcount = _o_.fightcount;
/*  112 */     this.starttime = _o_.starttime;
/*  113 */     this.isawarded = _o_.isawarded;
/*  114 */     this.iskilledmonster = _o_.iskilledmonster;
/*  115 */     this.reserved = _o_.reserved;
/*  116 */     this.ocp2damagepoint = new HashMap();
/*  117 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet()) {
/*  118 */       this.ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     _os_.marshal(this.damagepoint);
/*  126 */     _os_.marshal(this.rank);
/*  127 */     _os_.marshal(this.buycount);
/*  128 */     _os_.marshal(this.restbuycount);
/*  129 */     _os_.marshal(this.challengecount);
/*  130 */     _os_.marshal(this.fightcount);
/*  131 */     _os_.marshal(this.starttime);
/*  132 */     _os_.marshal(this.isawarded);
/*  133 */     _os_.marshal(this.iskilledmonster);
/*  134 */     _os_.marshal(this.reserved);
/*  135 */     _os_.compact_uint32(this.ocp2damagepoint.size());
/*  136 */     for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */     {
/*  138 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  139 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  141 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*  148 */     this.damagepoint = _os_.unmarshal_int();
/*  149 */     this.rank = _os_.unmarshal_int();
/*  150 */     this.buycount = _os_.unmarshal_int();
/*  151 */     this.restbuycount = _os_.unmarshal_int();
/*  152 */     this.challengecount = _os_.unmarshal_int();
/*  153 */     this.fightcount = _os_.unmarshal_int();
/*  154 */     this.starttime = _os_.unmarshal_long();
/*  155 */     this.isawarded = _os_.unmarshal_boolean();
/*  156 */     this.iskilledmonster = _os_.unmarshal_boolean();
/*  157 */     this.reserved = _os_.unmarshal_int();
/*      */     
/*  159 */     int size = _os_.uncompact_uint32();
/*  160 */     if (size >= 12)
/*      */     {
/*  162 */       this.ocp2damagepoint = new HashMap(size * 2);
/*      */     }
/*  164 */     for (; size > 0; size--)
/*      */     {
/*  166 */       int _k_ = 0;
/*  167 */       _k_ = _os_.unmarshal_int();
/*  168 */       int _v_ = 0;
/*  169 */       _v_ = _os_.unmarshal_int();
/*  170 */       this.ocp2damagepoint.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  173 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*  180 */     int _size_ = 0;
/*  181 */     _size_ += CodedOutputStream.computeInt32Size(1, this.damagepoint);
/*  182 */     _size_ += CodedOutputStream.computeInt32Size(2, this.rank);
/*  183 */     _size_ += CodedOutputStream.computeInt32Size(3, this.buycount);
/*  184 */     _size_ += CodedOutputStream.computeInt32Size(4, this.restbuycount);
/*  185 */     _size_ += CodedOutputStream.computeInt32Size(5, this.challengecount);
/*  186 */     _size_ += CodedOutputStream.computeInt32Size(6, this.fightcount);
/*  187 */     _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/*  188 */     _size_ += CodedOutputStream.computeBoolSize(8, this.isawarded);
/*  189 */     _size_ += CodedOutputStream.computeBoolSize(9, this.iskilledmonster);
/*  190 */     _size_ += CodedOutputStream.computeInt32Size(10, this.reserved);
/*  191 */     for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */     {
/*  193 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/*  194 */       _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  196 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  202 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  205 */       _output_.writeInt32(1, this.damagepoint);
/*  206 */       _output_.writeInt32(2, this.rank);
/*  207 */       _output_.writeInt32(3, this.buycount);
/*  208 */       _output_.writeInt32(4, this.restbuycount);
/*  209 */       _output_.writeInt32(5, this.challengecount);
/*  210 */       _output_.writeInt32(6, this.fightcount);
/*  211 */       _output_.writeInt64(7, this.starttime);
/*  212 */       _output_.writeBool(8, this.isawarded);
/*  213 */       _output_.writeBool(9, this.iskilledmonster);
/*  214 */       _output_.writeInt32(10, this.reserved);
/*  215 */       for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */       {
/*  217 */         _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/*  218 */         _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  223 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  225 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  231 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  234 */       boolean done = false;
/*  235 */       while (!done)
/*      */       {
/*  237 */         int tag = _input_.readTag();
/*  238 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  242 */           done = true;
/*  243 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  247 */           this.damagepoint = _input_.readInt32();
/*  248 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  252 */           this.rank = _input_.readInt32();
/*  253 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  257 */           this.buycount = _input_.readInt32();
/*  258 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  262 */           this.restbuycount = _input_.readInt32();
/*  263 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  267 */           this.challengecount = _input_.readInt32();
/*  268 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  272 */           this.fightcount = _input_.readInt32();
/*  273 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  277 */           this.starttime = _input_.readInt64();
/*  278 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  282 */           this.isawarded = _input_.readBool();
/*  283 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  287 */           this.iskilledmonster = _input_.readBool();
/*  288 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  292 */           this.reserved = _input_.readInt32();
/*  293 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  297 */           int _k_ = 0;
/*  298 */           _k_ = _input_.readInt32();
/*  299 */           int readTag = _input_.readTag();
/*  300 */           if (88 != readTag)
/*      */           {
/*  302 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  304 */           int _v_ = 0;
/*  305 */           _v_ = _input_.readInt32();
/*  306 */           this.ocp2damagepoint.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  307 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  311 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  313 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  322 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  326 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  328 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BigBoss copy()
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     return new BigBoss(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BigBoss toData()
/*      */   {
/*  341 */     _xdb_verify_unsafe_();
/*  342 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BigBoss toBean()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return new BigBoss(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BigBoss toDataIf()
/*      */   {
/*  354 */     _xdb_verify_unsafe_();
/*  355 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BigBoss toBeanIf()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDamagepoint()
/*      */   {
/*  375 */     _xdb_verify_unsafe_();
/*  376 */     return this.damagepoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRank()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return this.rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBuycount()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return this.buycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRestbuycount()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return this.restbuycount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getChallengecount()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return this.challengecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getFightcount()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return this.fightcount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsawarded()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return this.isawarded;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIskilledmonster()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     return this.iskilledmonster;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReserved()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return this.reserved;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOcp2damagepoint()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return Logs.logMap(new LogKey(this, "ocp2damagepoint"), this.ocp2damagepoint);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getOcp2damagepointAsData()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*      */     
/*  465 */     BigBoss _o_ = this;
/*  466 */     Map<Integer, Integer> ocp2damagepoint = new HashMap();
/*  467 */     for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet())
/*  468 */       ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*  469 */     return ocp2damagepoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDamagepoint(int _v_)
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*  477 */     Logs.logIf(new LogKey(this, "damagepoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  481 */         new LogInt(this, BigBoss.this.damagepoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  485 */             BigBoss.this.damagepoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  489 */     });
/*  490 */     this.damagepoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRank(int _v_)
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     Logs.logIf(new LogKey(this, "rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  502 */         new LogInt(this, BigBoss.this.rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  506 */             BigBoss.this.rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  510 */     });
/*  511 */     this.rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuycount(int _v_)
/*      */   {
/*  518 */     _xdb_verify_unsafe_();
/*  519 */     Logs.logIf(new LogKey(this, "buycount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  523 */         new LogInt(this, BigBoss.this.buycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  527 */             BigBoss.this.buycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  531 */     });
/*  532 */     this.buycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRestbuycount(int _v_)
/*      */   {
/*  539 */     _xdb_verify_unsafe_();
/*  540 */     Logs.logIf(new LogKey(this, "restbuycount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  544 */         new LogInt(this, BigBoss.this.restbuycount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  548 */             BigBoss.this.restbuycount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  552 */     });
/*  553 */     this.restbuycount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setChallengecount(int _v_)
/*      */   {
/*  560 */     _xdb_verify_unsafe_();
/*  561 */     Logs.logIf(new LogKey(this, "challengecount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  565 */         new LogInt(this, BigBoss.this.challengecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  569 */             BigBoss.this.challengecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  573 */     });
/*  574 */     this.challengecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFightcount(int _v_)
/*      */   {
/*  581 */     _xdb_verify_unsafe_();
/*  582 */     Logs.logIf(new LogKey(this, "fightcount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  586 */         new LogInt(this, BigBoss.this.fightcount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  590 */             BigBoss.this.fightcount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  594 */     });
/*  595 */     this.fightcount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  602 */     _xdb_verify_unsafe_();
/*  603 */     Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  607 */         new xdb.logs.LogLong(this, BigBoss.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  611 */             BigBoss.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  615 */     });
/*  616 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsawarded(boolean _v_)
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     Logs.logIf(new LogKey(this, "isawarded")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  628 */         new LogObject(this, Boolean.valueOf(BigBoss.this.isawarded))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  632 */             BigBoss.this.isawarded = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  636 */     });
/*  637 */     this.isawarded = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIskilledmonster(boolean _v_)
/*      */   {
/*  644 */     _xdb_verify_unsafe_();
/*  645 */     Logs.logIf(new LogKey(this, "iskilledmonster")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  649 */         new LogObject(this, Boolean.valueOf(BigBoss.this.iskilledmonster))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  653 */             BigBoss.this.iskilledmonster = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  657 */     });
/*  658 */     this.iskilledmonster = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReserved(int _v_)
/*      */   {
/*  665 */     _xdb_verify_unsafe_();
/*  666 */     Logs.logIf(new LogKey(this, "reserved")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  670 */         new LogInt(this, BigBoss.this.reserved)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  674 */             BigBoss.this.reserved = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  678 */     });
/*  679 */     this.reserved = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  685 */     _xdb_verify_unsafe_();
/*  686 */     BigBoss _o_ = null;
/*  687 */     if ((_o1_ instanceof BigBoss)) { _o_ = (BigBoss)_o1_;
/*  688 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  689 */       return false;
/*  690 */     if (this.damagepoint != _o_.damagepoint) return false;
/*  691 */     if (this.rank != _o_.rank) return false;
/*  692 */     if (this.buycount != _o_.buycount) return false;
/*  693 */     if (this.restbuycount != _o_.restbuycount) return false;
/*  694 */     if (this.challengecount != _o_.challengecount) return false;
/*  695 */     if (this.fightcount != _o_.fightcount) return false;
/*  696 */     if (this.starttime != _o_.starttime) return false;
/*  697 */     if (this.isawarded != _o_.isawarded) return false;
/*  698 */     if (this.iskilledmonster != _o_.iskilledmonster) return false;
/*  699 */     if (this.reserved != _o_.reserved) return false;
/*  700 */     if (!this.ocp2damagepoint.equals(_o_.ocp2damagepoint)) return false;
/*  701 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  707 */     _xdb_verify_unsafe_();
/*  708 */     int _h_ = 0;
/*  709 */     _h_ += this.damagepoint;
/*  710 */     _h_ += this.rank;
/*  711 */     _h_ += this.buycount;
/*  712 */     _h_ += this.restbuycount;
/*  713 */     _h_ += this.challengecount;
/*  714 */     _h_ += this.fightcount;
/*  715 */     _h_ = (int)(_h_ + this.starttime);
/*  716 */     _h_ += (this.isawarded ? 1231 : 1237);
/*  717 */     _h_ += (this.iskilledmonster ? 1231 : 1237);
/*  718 */     _h_ += this.reserved;
/*  719 */     _h_ += this.ocp2damagepoint.hashCode();
/*  720 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  726 */     _xdb_verify_unsafe_();
/*  727 */     StringBuilder _sb_ = new StringBuilder();
/*  728 */     _sb_.append("(");
/*  729 */     _sb_.append(this.damagepoint);
/*  730 */     _sb_.append(",");
/*  731 */     _sb_.append(this.rank);
/*  732 */     _sb_.append(",");
/*  733 */     _sb_.append(this.buycount);
/*  734 */     _sb_.append(",");
/*  735 */     _sb_.append(this.restbuycount);
/*  736 */     _sb_.append(",");
/*  737 */     _sb_.append(this.challengecount);
/*  738 */     _sb_.append(",");
/*  739 */     _sb_.append(this.fightcount);
/*  740 */     _sb_.append(",");
/*  741 */     _sb_.append(this.starttime);
/*  742 */     _sb_.append(",");
/*  743 */     _sb_.append(this.isawarded);
/*  744 */     _sb_.append(",");
/*  745 */     _sb_.append(this.iskilledmonster);
/*  746 */     _sb_.append(",");
/*  747 */     _sb_.append(this.reserved);
/*  748 */     _sb_.append(",");
/*  749 */     _sb_.append(this.ocp2damagepoint);
/*  750 */     _sb_.append(")");
/*  751 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  757 */     ListenableBean lb = new ListenableBean();
/*  758 */     lb.add(new ListenableChanged().setVarName("damagepoint"));
/*  759 */     lb.add(new ListenableChanged().setVarName("rank"));
/*  760 */     lb.add(new ListenableChanged().setVarName("buycount"));
/*  761 */     lb.add(new ListenableChanged().setVarName("restbuycount"));
/*  762 */     lb.add(new ListenableChanged().setVarName("challengecount"));
/*  763 */     lb.add(new ListenableChanged().setVarName("fightcount"));
/*  764 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  765 */     lb.add(new ListenableChanged().setVarName("isawarded"));
/*  766 */     lb.add(new ListenableChanged().setVarName("iskilledmonster"));
/*  767 */     lb.add(new ListenableChanged().setVarName("reserved"));
/*  768 */     lb.add(new xdb.logs.ListenableMap().setVarName("ocp2damagepoint"));
/*  769 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BigBoss {
/*      */     private Const() {}
/*      */     
/*      */     BigBoss nThis() {
/*  776 */       return BigBoss.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  782 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss copy()
/*      */     {
/*  788 */       return BigBoss.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss toData()
/*      */     {
/*  794 */       return BigBoss.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BigBoss toBean()
/*      */     {
/*  799 */       return BigBoss.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss toDataIf()
/*      */     {
/*  805 */       return BigBoss.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BigBoss toBeanIf()
/*      */     {
/*  810 */       return BigBoss.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDamagepoint()
/*      */     {
/*  817 */       BigBoss.this._xdb_verify_unsafe_();
/*  818 */       return BigBoss.this.damagepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRank()
/*      */     {
/*  825 */       BigBoss.this._xdb_verify_unsafe_();
/*  826 */       return BigBoss.this.rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuycount()
/*      */     {
/*  833 */       BigBoss.this._xdb_verify_unsafe_();
/*  834 */       return BigBoss.this.buycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRestbuycount()
/*      */     {
/*  841 */       BigBoss.this._xdb_verify_unsafe_();
/*  842 */       return BigBoss.this.restbuycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallengecount()
/*      */     {
/*  849 */       BigBoss.this._xdb_verify_unsafe_();
/*  850 */       return BigBoss.this.challengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightcount()
/*      */     {
/*  857 */       BigBoss.this._xdb_verify_unsafe_();
/*  858 */       return BigBoss.this.fightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  865 */       BigBoss.this._xdb_verify_unsafe_();
/*  866 */       return BigBoss.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsawarded()
/*      */     {
/*  873 */       BigBoss.this._xdb_verify_unsafe_();
/*  874 */       return BigBoss.this.isawarded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIskilledmonster()
/*      */     {
/*  881 */       BigBoss.this._xdb_verify_unsafe_();
/*  882 */       return BigBoss.this.iskilledmonster;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReserved()
/*      */     {
/*  889 */       BigBoss.this._xdb_verify_unsafe_();
/*  890 */       return BigBoss.this.reserved;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcp2damagepoint()
/*      */     {
/*  897 */       BigBoss.this._xdb_verify_unsafe_();
/*  898 */       return xdb.Consts.constMap(BigBoss.this.ocp2damagepoint);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcp2damagepointAsData()
/*      */     {
/*  905 */       BigBoss.this._xdb_verify_unsafe_();
/*      */       
/*  907 */       BigBoss _o_ = BigBoss.this;
/*  908 */       Map<Integer, Integer> ocp2damagepoint = new HashMap();
/*  909 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet())
/*  910 */         ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*  911 */       return ocp2damagepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDamagepoint(int _v_)
/*      */     {
/*  918 */       BigBoss.this._xdb_verify_unsafe_();
/*  919 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRank(int _v_)
/*      */     {
/*  926 */       BigBoss.this._xdb_verify_unsafe_();
/*  927 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuycount(int _v_)
/*      */     {
/*  934 */       BigBoss.this._xdb_verify_unsafe_();
/*  935 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRestbuycount(int _v_)
/*      */     {
/*  942 */       BigBoss.this._xdb_verify_unsafe_();
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallengecount(int _v_)
/*      */     {
/*  950 */       BigBoss.this._xdb_verify_unsafe_();
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightcount(int _v_)
/*      */     {
/*  958 */       BigBoss.this._xdb_verify_unsafe_();
/*  959 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  966 */       BigBoss.this._xdb_verify_unsafe_();
/*  967 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsawarded(boolean _v_)
/*      */     {
/*  974 */       BigBoss.this._xdb_verify_unsafe_();
/*  975 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIskilledmonster(boolean _v_)
/*      */     {
/*  982 */       BigBoss.this._xdb_verify_unsafe_();
/*  983 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReserved(int _v_)
/*      */     {
/*  990 */       BigBoss.this._xdb_verify_unsafe_();
/*  991 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  997 */       BigBoss.this._xdb_verify_unsafe_();
/*  998 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1004 */       BigBoss.this._xdb_verify_unsafe_();
/* 1005 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1011 */       return BigBoss.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1017 */       return BigBoss.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1023 */       BigBoss.this._xdb_verify_unsafe_();
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1030 */       return BigBoss.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1036 */       return BigBoss.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1042 */       BigBoss.this._xdb_verify_unsafe_();
/* 1043 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1049 */       return BigBoss.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1055 */       return BigBoss.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1061 */       return BigBoss.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1067 */       return BigBoss.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1073 */       return BigBoss.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1079 */       return BigBoss.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1085 */       return BigBoss.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BigBoss
/*      */   {
/*      */     private int damagepoint;
/*      */     
/*      */     private int rank;
/*      */     
/*      */     private int buycount;
/*      */     
/*      */     private int restbuycount;
/*      */     
/*      */     private int challengecount;
/*      */     
/*      */     private int fightcount;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private boolean isawarded;
/*      */     
/*      */     private boolean iskilledmonster;
/*      */     
/*      */     private int reserved;
/*      */     
/*      */     private HashMap<Integer, Integer> ocp2damagepoint;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1117 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1122 */       this.damagepoint = 0;
/* 1123 */       this.rank = 0;
/* 1124 */       this.buycount = 0;
/* 1125 */       this.restbuycount = 0;
/* 1126 */       this.challengecount = 0;
/* 1127 */       this.fightcount = 0;
/* 1128 */       this.starttime = 0L;
/* 1129 */       this.isawarded = false;
/* 1130 */       this.iskilledmonster = false;
/* 1131 */       this.reserved = 0;
/* 1132 */       this.ocp2damagepoint = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BigBoss _o1_)
/*      */     {
/* 1137 */       if ((_o1_ instanceof BigBoss)) { assign((BigBoss)_o1_);
/* 1138 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1139 */       } else if ((_o1_ instanceof BigBoss.Const)) assign(((BigBoss.Const)_o1_).nThis()); else {
/* 1140 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BigBoss _o_) {
/* 1145 */       this.damagepoint = _o_.damagepoint;
/* 1146 */       this.rank = _o_.rank;
/* 1147 */       this.buycount = _o_.buycount;
/* 1148 */       this.restbuycount = _o_.restbuycount;
/* 1149 */       this.challengecount = _o_.challengecount;
/* 1150 */       this.fightcount = _o_.fightcount;
/* 1151 */       this.starttime = _o_.starttime;
/* 1152 */       this.isawarded = _o_.isawarded;
/* 1153 */       this.iskilledmonster = _o_.iskilledmonster;
/* 1154 */       this.reserved = _o_.reserved;
/* 1155 */       this.ocp2damagepoint = new HashMap();
/* 1156 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet()) {
/* 1157 */         this.ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/* 1162 */       this.damagepoint = _o_.damagepoint;
/* 1163 */       this.rank = _o_.rank;
/* 1164 */       this.buycount = _o_.buycount;
/* 1165 */       this.restbuycount = _o_.restbuycount;
/* 1166 */       this.challengecount = _o_.challengecount;
/* 1167 */       this.fightcount = _o_.fightcount;
/* 1168 */       this.starttime = _o_.starttime;
/* 1169 */       this.isawarded = _o_.isawarded;
/* 1170 */       this.iskilledmonster = _o_.iskilledmonster;
/* 1171 */       this.reserved = _o_.reserved;
/* 1172 */       this.ocp2damagepoint = new HashMap();
/* 1173 */       for (Map.Entry<Integer, Integer> _e_ : _o_.ocp2damagepoint.entrySet()) {
/* 1174 */         this.ocp2damagepoint.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1180 */       _os_.marshal(this.damagepoint);
/* 1181 */       _os_.marshal(this.rank);
/* 1182 */       _os_.marshal(this.buycount);
/* 1183 */       _os_.marshal(this.restbuycount);
/* 1184 */       _os_.marshal(this.challengecount);
/* 1185 */       _os_.marshal(this.fightcount);
/* 1186 */       _os_.marshal(this.starttime);
/* 1187 */       _os_.marshal(this.isawarded);
/* 1188 */       _os_.marshal(this.iskilledmonster);
/* 1189 */       _os_.marshal(this.reserved);
/* 1190 */       _os_.compact_uint32(this.ocp2damagepoint.size());
/* 1191 */       for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */       {
/* 1193 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1194 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1196 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1202 */       this.damagepoint = _os_.unmarshal_int();
/* 1203 */       this.rank = _os_.unmarshal_int();
/* 1204 */       this.buycount = _os_.unmarshal_int();
/* 1205 */       this.restbuycount = _os_.unmarshal_int();
/* 1206 */       this.challengecount = _os_.unmarshal_int();
/* 1207 */       this.fightcount = _os_.unmarshal_int();
/* 1208 */       this.starttime = _os_.unmarshal_long();
/* 1209 */       this.isawarded = _os_.unmarshal_boolean();
/* 1210 */       this.iskilledmonster = _os_.unmarshal_boolean();
/* 1211 */       this.reserved = _os_.unmarshal_int();
/*      */       
/* 1213 */       int size = _os_.uncompact_uint32();
/* 1214 */       if (size >= 12)
/*      */       {
/* 1216 */         this.ocp2damagepoint = new HashMap(size * 2);
/*      */       }
/* 1218 */       for (; size > 0; size--)
/*      */       {
/* 1220 */         int _k_ = 0;
/* 1221 */         _k_ = _os_.unmarshal_int();
/* 1222 */         int _v_ = 0;
/* 1223 */         _v_ = _os_.unmarshal_int();
/* 1224 */         this.ocp2damagepoint.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1227 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1233 */       int _size_ = 0;
/* 1234 */       _size_ += CodedOutputStream.computeInt32Size(1, this.damagepoint);
/* 1235 */       _size_ += CodedOutputStream.computeInt32Size(2, this.rank);
/* 1236 */       _size_ += CodedOutputStream.computeInt32Size(3, this.buycount);
/* 1237 */       _size_ += CodedOutputStream.computeInt32Size(4, this.restbuycount);
/* 1238 */       _size_ += CodedOutputStream.computeInt32Size(5, this.challengecount);
/* 1239 */       _size_ += CodedOutputStream.computeInt32Size(6, this.fightcount);
/* 1240 */       _size_ += CodedOutputStream.computeInt64Size(7, this.starttime);
/* 1241 */       _size_ += CodedOutputStream.computeBoolSize(8, this.isawarded);
/* 1242 */       _size_ += CodedOutputStream.computeBoolSize(9, this.iskilledmonster);
/* 1243 */       _size_ += CodedOutputStream.computeInt32Size(10, this.reserved);
/* 1244 */       for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */       {
/* 1246 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getKey()).intValue());
/* 1247 */         _size_ += CodedOutputStream.computeInt32Size(11, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1249 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1257 */         _output_.writeInt32(1, this.damagepoint);
/* 1258 */         _output_.writeInt32(2, this.rank);
/* 1259 */         _output_.writeInt32(3, this.buycount);
/* 1260 */         _output_.writeInt32(4, this.restbuycount);
/* 1261 */         _output_.writeInt32(5, this.challengecount);
/* 1262 */         _output_.writeInt32(6, this.fightcount);
/* 1263 */         _output_.writeInt64(7, this.starttime);
/* 1264 */         _output_.writeBool(8, this.isawarded);
/* 1265 */         _output_.writeBool(9, this.iskilledmonster);
/* 1266 */         _output_.writeInt32(10, this.reserved);
/* 1267 */         for (Map.Entry<Integer, Integer> _e_ : this.ocp2damagepoint.entrySet())
/*      */         {
/* 1269 */           _output_.writeInt32(11, ((Integer)_e_.getKey()).intValue());
/* 1270 */           _output_.writeInt32(11, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1275 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1277 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1285 */         boolean done = false;
/* 1286 */         while (!done)
/*      */         {
/* 1288 */           int tag = _input_.readTag();
/* 1289 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1293 */             done = true;
/* 1294 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1298 */             this.damagepoint = _input_.readInt32();
/* 1299 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1303 */             this.rank = _input_.readInt32();
/* 1304 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1308 */             this.buycount = _input_.readInt32();
/* 1309 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1313 */             this.restbuycount = _input_.readInt32();
/* 1314 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1318 */             this.challengecount = _input_.readInt32();
/* 1319 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1323 */             this.fightcount = _input_.readInt32();
/* 1324 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1328 */             this.starttime = _input_.readInt64();
/* 1329 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1333 */             this.isawarded = _input_.readBool();
/* 1334 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1338 */             this.iskilledmonster = _input_.readBool();
/* 1339 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1343 */             this.reserved = _input_.readInt32();
/* 1344 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1348 */             int _k_ = 0;
/* 1349 */             _k_ = _input_.readInt32();
/* 1350 */             int readTag = _input_.readTag();
/* 1351 */             if (88 != readTag)
/*      */             {
/* 1353 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1355 */             int _v_ = 0;
/* 1356 */             _v_ = _input_.readInt32();
/* 1357 */             this.ocp2damagepoint.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/* 1358 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1362 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1364 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1373 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1377 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1379 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss copy()
/*      */     {
/* 1385 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss toData()
/*      */     {
/* 1391 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BigBoss toBean()
/*      */     {
/* 1396 */       return new BigBoss(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BigBoss toDataIf()
/*      */     {
/* 1402 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BigBoss toBeanIf()
/*      */     {
/* 1407 */       return new BigBoss(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1413 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1417 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1421 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1425 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1429 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1433 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1437 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDamagepoint()
/*      */     {
/* 1444 */       return this.damagepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRank()
/*      */     {
/* 1451 */       return this.rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBuycount()
/*      */     {
/* 1458 */       return this.buycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRestbuycount()
/*      */     {
/* 1465 */       return this.restbuycount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getChallengecount()
/*      */     {
/* 1472 */       return this.challengecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getFightcount()
/*      */     {
/* 1479 */       return this.fightcount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1486 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsawarded()
/*      */     {
/* 1493 */       return this.isawarded;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIskilledmonster()
/*      */     {
/* 1500 */       return this.iskilledmonster;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReserved()
/*      */     {
/* 1507 */       return this.reserved;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcp2damagepoint()
/*      */     {
/* 1514 */       return this.ocp2damagepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getOcp2damagepointAsData()
/*      */     {
/* 1521 */       return this.ocp2damagepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDamagepoint(int _v_)
/*      */     {
/* 1528 */       this.damagepoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRank(int _v_)
/*      */     {
/* 1535 */       this.rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuycount(int _v_)
/*      */     {
/* 1542 */       this.buycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRestbuycount(int _v_)
/*      */     {
/* 1549 */       this.restbuycount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setChallengecount(int _v_)
/*      */     {
/* 1556 */       this.challengecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFightcount(int _v_)
/*      */     {
/* 1563 */       this.fightcount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1570 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsawarded(boolean _v_)
/*      */     {
/* 1577 */       this.isawarded = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIskilledmonster(boolean _v_)
/*      */     {
/* 1584 */       this.iskilledmonster = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReserved(int _v_)
/*      */     {
/* 1591 */       this.reserved = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1597 */       if (!(_o1_ instanceof Data)) return false;
/* 1598 */       Data _o_ = (Data)_o1_;
/* 1599 */       if (this.damagepoint != _o_.damagepoint) return false;
/* 1600 */       if (this.rank != _o_.rank) return false;
/* 1601 */       if (this.buycount != _o_.buycount) return false;
/* 1602 */       if (this.restbuycount != _o_.restbuycount) return false;
/* 1603 */       if (this.challengecount != _o_.challengecount) return false;
/* 1604 */       if (this.fightcount != _o_.fightcount) return false;
/* 1605 */       if (this.starttime != _o_.starttime) return false;
/* 1606 */       if (this.isawarded != _o_.isawarded) return false;
/* 1607 */       if (this.iskilledmonster != _o_.iskilledmonster) return false;
/* 1608 */       if (this.reserved != _o_.reserved) return false;
/* 1609 */       if (!this.ocp2damagepoint.equals(_o_.ocp2damagepoint)) return false;
/* 1610 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1616 */       int _h_ = 0;
/* 1617 */       _h_ += this.damagepoint;
/* 1618 */       _h_ += this.rank;
/* 1619 */       _h_ += this.buycount;
/* 1620 */       _h_ += this.restbuycount;
/* 1621 */       _h_ += this.challengecount;
/* 1622 */       _h_ += this.fightcount;
/* 1623 */       _h_ = (int)(_h_ + this.starttime);
/* 1624 */       _h_ += (this.isawarded ? 1231 : 1237);
/* 1625 */       _h_ += (this.iskilledmonster ? 1231 : 1237);
/* 1626 */       _h_ += this.reserved;
/* 1627 */       _h_ += this.ocp2damagepoint.hashCode();
/* 1628 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1634 */       StringBuilder _sb_ = new StringBuilder();
/* 1635 */       _sb_.append("(");
/* 1636 */       _sb_.append(this.damagepoint);
/* 1637 */       _sb_.append(",");
/* 1638 */       _sb_.append(this.rank);
/* 1639 */       _sb_.append(",");
/* 1640 */       _sb_.append(this.buycount);
/* 1641 */       _sb_.append(",");
/* 1642 */       _sb_.append(this.restbuycount);
/* 1643 */       _sb_.append(",");
/* 1644 */       _sb_.append(this.challengecount);
/* 1645 */       _sb_.append(",");
/* 1646 */       _sb_.append(this.fightcount);
/* 1647 */       _sb_.append(",");
/* 1648 */       _sb_.append(this.starttime);
/* 1649 */       _sb_.append(",");
/* 1650 */       _sb_.append(this.isawarded);
/* 1651 */       _sb_.append(",");
/* 1652 */       _sb_.append(this.iskilledmonster);
/* 1653 */       _sb_.append(",");
/* 1654 */       _sb_.append(this.reserved);
/* 1655 */       _sb_.append(",");
/* 1656 */       _sb_.append(this.ocp2damagepoint);
/* 1657 */       _sb_.append(")");
/* 1658 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BigBoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */