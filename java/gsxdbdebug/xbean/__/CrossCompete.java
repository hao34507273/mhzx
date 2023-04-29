/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import ppbio.Message;
/*      */ import xbean.CrossCompeteMatch;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class CrossCompete extends xdb.XBean implements xbean.CrossCompete
/*      */ {
/*      */   private HashMap<Long, xbean.CrossCompeteSignUp> signup_factions;
/*      */   private int matchtimes;
/*      */   private HashMap<CrossCompeteMatch, xbean.CrossCompeteAgainst> againsts;
/*      */   private SetX<Long> miss_turn_factions;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.signup_factions.clear();
/*   25 */     this.matchtimes = 0;
/*   26 */     this.againsts.clear();
/*   27 */     this.miss_turn_factions.clear();
/*      */   }
/*      */   
/*      */   CrossCompete(int __, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.signup_factions = new HashMap();
/*   34 */     this.matchtimes = 0;
/*   35 */     this.againsts = new HashMap();
/*   36 */     this.miss_turn_factions = new SetX();
/*      */   }
/*      */   
/*      */   public CrossCompete()
/*      */   {
/*   41 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public CrossCompete(CrossCompete _o_)
/*      */   {
/*   46 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   CrossCompete(xbean.CrossCompete _o1_, xdb.XBean _xp_, String _vn_)
/*      */   {
/*   51 */     super(_xp_, _vn_);
/*   52 */     if ((_o1_ instanceof CrossCompete)) { assign((CrossCompete)_o1_);
/*   53 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   54 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   55 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(CrossCompete _o_) {
/*   60 */     _o_._xdb_verify_unsafe_();
/*   61 */     this.signup_factions = new HashMap();
/*   62 */     for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*   63 */       this.signup_factions.put(_e_.getKey(), new CrossCompeteSignUp((xbean.CrossCompeteSignUp)_e_.getValue(), this, "signup_factions"));
/*   64 */     this.matchtimes = _o_.matchtimes;
/*   65 */     this.againsts = new HashMap();
/*   66 */     for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*   67 */       this.againsts.put(_e_.getKey(), new CrossCompeteAgainst((xbean.CrossCompeteAgainst)_e_.getValue(), this, "againsts"));
/*   68 */     this.miss_turn_factions = new SetX();
/*   69 */     this.miss_turn_factions.addAll(_o_.miss_turn_factions);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   74 */     this.signup_factions = new HashMap();
/*   75 */     for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*   76 */       this.signup_factions.put(_e_.getKey(), new CrossCompeteSignUp((xbean.CrossCompeteSignUp)_e_.getValue(), this, "signup_factions"));
/*   77 */     this.matchtimes = _o_.matchtimes;
/*   78 */     this.againsts = new HashMap();
/*   79 */     for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*   80 */       this.againsts.put(_e_.getKey(), new CrossCompeteAgainst((xbean.CrossCompeteAgainst)_e_.getValue(), this, "againsts"));
/*   81 */     this.miss_turn_factions = new SetX();
/*   82 */     this.miss_turn_factions.addAll(_o_.miss_turn_factions);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   88 */     _xdb_verify_unsafe_();
/*   89 */     _os_.compact_uint32(this.signup_factions.size());
/*   90 */     for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */     {
/*   92 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*   93 */       ((xbean.CrossCompeteSignUp)_e_.getValue()).marshal(_os_);
/*      */     }
/*   95 */     _os_.marshal(this.matchtimes);
/*   96 */     _os_.compact_uint32(this.againsts.size());
/*   97 */     for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */     {
/*   99 */       ((CrossCompeteMatch)_e_.getKey()).marshal(_os_);
/*  100 */       ((xbean.CrossCompeteAgainst)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.compact_uint32(this.miss_turn_factions.size());
/*  103 */     for (Long _v_ : this.miss_turn_factions)
/*      */     {
/*  105 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  107 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  113 */     _xdb_verify_unsafe_();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.signup_factions = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       long _k_ = 0L;
/*  123 */       _k_ = _os_.unmarshal_long();
/*  124 */       xbean.CrossCompeteSignUp _v_ = new CrossCompeteSignUp(0, this, "signup_factions");
/*  125 */       _v_.unmarshal(_os_);
/*  126 */       this.signup_factions.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  129 */     this.matchtimes = _os_.unmarshal_int();
/*      */     
/*  131 */     int size = _os_.uncompact_uint32();
/*  132 */     if (size >= 12)
/*      */     {
/*  134 */       this.againsts = new HashMap(size * 2);
/*      */     }
/*  136 */     for (; size > 0; size--)
/*      */     {
/*  138 */       CrossCompeteMatch _k_ = new CrossCompeteMatch();
/*  139 */       _k_.unmarshal(_os_);
/*  140 */       xbean.CrossCompeteAgainst _v_ = new CrossCompeteAgainst(0, this, "againsts");
/*  141 */       _v_.unmarshal(_os_);
/*  142 */       this.againsts.put(_k_, _v_);
/*      */     }
/*      */     
/*  145 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  147 */       long _v_ = 0L;
/*  148 */       _v_ = _os_.unmarshal_long();
/*  149 */       this.miss_turn_factions.add(Long.valueOf(_v_));
/*      */     }
/*  151 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*  158 */     int _size_ = 0;
/*  159 */     for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  162 */       _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */     }
/*  164 */     _size_ += CodedOutputStream.computeInt32Size(2, this.matchtimes);
/*  165 */     for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */     {
/*  167 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getKey());
/*  168 */       _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */     }
/*  170 */     for (Long _v_ : this.miss_turn_factions)
/*      */     {
/*  172 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */       {
/*  185 */         _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  186 */         _output_.writeMessage(1, (Message)_e_.getValue());
/*      */       }
/*  188 */       _output_.writeInt32(2, this.matchtimes);
/*  189 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  191 */         _output_.writeMessage(3, (Message)_e_.getKey());
/*  192 */         _output_.writeMessage(3, (Message)_e_.getValue());
/*      */       }
/*  194 */       for (Long _v_ : this.miss_turn_factions)
/*      */       {
/*  196 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  201 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  203 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  209 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  212 */       boolean done = false;
/*  213 */       while (!done)
/*      */       {
/*  215 */         int tag = _input_.readTag();
/*  216 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  220 */           done = true;
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  225 */           long _k_ = 0L;
/*  226 */           _k_ = _input_.readInt64();
/*  227 */           int readTag = _input_.readTag();
/*  228 */           if (10 != readTag)
/*      */           {
/*  230 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  232 */           xbean.CrossCompeteSignUp _v_ = new CrossCompeteSignUp(0, this, "signup_factions");
/*  233 */           _input_.readMessage(_v_);
/*  234 */           this.signup_factions.put(Long.valueOf(_k_), _v_);
/*  235 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  239 */           this.matchtimes = _input_.readInt32();
/*  240 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  244 */           CrossCompeteMatch _k_ = new CrossCompeteMatch();
/*  245 */           _input_.readMessage(_k_);
/*  246 */           int readTag = _input_.readTag();
/*  247 */           if (26 != readTag)
/*      */           {
/*  249 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  251 */           xbean.CrossCompeteAgainst _v_ = new CrossCompeteAgainst(0, this, "againsts");
/*  252 */           _input_.readMessage(_v_);
/*  253 */           this.againsts.put(_k_, _v_);
/*  254 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  258 */           long _v_ = 0L;
/*  259 */           _v_ = _input_.readInt64();
/*  260 */           this.miss_turn_factions.add(Long.valueOf(_v_));
/*  261 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  265 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  267 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  276 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  280 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  282 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompete copy()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new CrossCompete(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompete toData()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompete toBean()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new CrossCompete(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.CrossCompete toDataIf()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.CrossCompete toBeanIf()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossCompeteSignUp> getSignup_factions()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return xdb.Logs.logMap(new xdb.LogKey(this, "signup_factions"), this.signup_factions);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.CrossCompeteSignUp> getSignup_factionsAsData()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*      */     
/*  339 */     CrossCompete _o_ = this;
/*  340 */     Map<Long, xbean.CrossCompeteSignUp> signup_factions = new HashMap();
/*  341 */     for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*  342 */       signup_factions.put(_e_.getKey(), new CrossCompeteSignUp.Data((xbean.CrossCompeteSignUp)_e_.getValue()));
/*  343 */     return signup_factions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMatchtimes()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.matchtimes;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainsts()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return xdb.Logs.logMap(new xdb.LogKey(this, "againsts"), this.againsts);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainstsAsData()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*      */     
/*  368 */     CrossCompete _o_ = this;
/*  369 */     Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> againsts = new HashMap();
/*  370 */     for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*  371 */       againsts.put(_e_.getKey(), new CrossCompeteAgainst.Data((xbean.CrossCompeteAgainst)_e_.getValue()));
/*  372 */     return againsts;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public java.util.Set<Long> getMiss_turn_factions()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return xdb.Logs.logSet(new xdb.LogKey(this, "miss_turn_factions"), this.miss_turn_factions);
/*      */   }
/*      */   
/*      */ 
/*      */   public java.util.Set<Long> getMiss_turn_factionsAsData()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*      */     
/*  388 */     CrossCompete _o_ = this;
/*  389 */     java.util.Set<Long> miss_turn_factions = new SetX();
/*  390 */     miss_turn_factions.addAll(_o_.miss_turn_factions);
/*  391 */     return miss_turn_factions;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMatchtimes(int _v_)
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     xdb.Logs.logIf(new xdb.LogKey(this, "matchtimes")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  403 */         new xdb.logs.LogInt(this, CrossCompete.this.matchtimes)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  407 */             CrossCompete.this.matchtimes = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  411 */     });
/*  412 */     this.matchtimes = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     CrossCompete _o_ = null;
/*  420 */     if ((_o1_ instanceof CrossCompete)) { _o_ = (CrossCompete)_o1_;
/*  421 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  422 */       return false;
/*  423 */     if (!this.signup_factions.equals(_o_.signup_factions)) return false;
/*  424 */     if (this.matchtimes != _o_.matchtimes) return false;
/*  425 */     if (!this.againsts.equals(_o_.againsts)) return false;
/*  426 */     if (!this.miss_turn_factions.equals(_o_.miss_turn_factions)) return false;
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     int _h_ = 0;
/*  435 */     _h_ += this.signup_factions.hashCode();
/*  436 */     _h_ += this.matchtimes;
/*  437 */     _h_ += this.againsts.hashCode();
/*  438 */     _h_ += this.miss_turn_factions.hashCode();
/*  439 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  445 */     _xdb_verify_unsafe_();
/*  446 */     StringBuilder _sb_ = new StringBuilder();
/*  447 */     _sb_.append("(");
/*  448 */     _sb_.append(this.signup_factions);
/*  449 */     _sb_.append(",");
/*  450 */     _sb_.append(this.matchtimes);
/*  451 */     _sb_.append(",");
/*  452 */     _sb_.append(this.againsts);
/*  453 */     _sb_.append(",");
/*  454 */     _sb_.append(this.miss_turn_factions);
/*  455 */     _sb_.append(")");
/*  456 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  462 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  463 */     lb.add(new xdb.logs.ListenableMap().setVarName("signup_factions"));
/*  464 */     lb.add(new xdb.logs.ListenableChanged().setVarName("matchtimes"));
/*  465 */     lb.add(new xdb.logs.ListenableMap().setVarName("againsts"));
/*  466 */     lb.add(new xdb.logs.ListenableSet().setVarName("miss_turn_factions"));
/*  467 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.CrossCompete {
/*      */     private Const() {}
/*      */     
/*      */     CrossCompete nThis() {
/*  474 */       return CrossCompete.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  480 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete copy()
/*      */     {
/*  486 */       return CrossCompete.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete toData()
/*      */     {
/*  492 */       return CrossCompete.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompete toBean()
/*      */     {
/*  497 */       return CrossCompete.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete toDataIf()
/*      */     {
/*  503 */       return CrossCompete.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.CrossCompete toBeanIf()
/*      */     {
/*  508 */       return CrossCompete.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossCompeteSignUp> getSignup_factions()
/*      */     {
/*  515 */       CrossCompete.this._xdb_verify_unsafe_();
/*  516 */       return xdb.Consts.constMap(CrossCompete.this.signup_factions);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossCompeteSignUp> getSignup_factionsAsData()
/*      */     {
/*  523 */       CrossCompete.this._xdb_verify_unsafe_();
/*      */       
/*  525 */       CrossCompete _o_ = CrossCompete.this;
/*  526 */       Map<Long, xbean.CrossCompeteSignUp> signup_factions = new HashMap();
/*  527 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*  528 */         signup_factions.put(_e_.getKey(), new CrossCompeteSignUp.Data((xbean.CrossCompeteSignUp)_e_.getValue()));
/*  529 */       return signup_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtimes()
/*      */     {
/*  536 */       CrossCompete.this._xdb_verify_unsafe_();
/*  537 */       return CrossCompete.this.matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainsts()
/*      */     {
/*  544 */       CrossCompete.this._xdb_verify_unsafe_();
/*  545 */       return xdb.Consts.constMap(CrossCompete.this.againsts);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainstsAsData()
/*      */     {
/*  552 */       CrossCompete.this._xdb_verify_unsafe_();
/*      */       
/*  554 */       CrossCompete _o_ = CrossCompete.this;
/*  555 */       Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> againsts = new HashMap();
/*  556 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*  557 */         againsts.put(_e_.getKey(), new CrossCompeteAgainst.Data((xbean.CrossCompeteAgainst)_e_.getValue()));
/*  558 */       return againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getMiss_turn_factions()
/*      */     {
/*  565 */       CrossCompete.this._xdb_verify_unsafe_();
/*  566 */       return xdb.Consts.constSet(CrossCompete.this.miss_turn_factions);
/*      */     }
/*      */     
/*      */ 
/*      */     public java.util.Set<Long> getMiss_turn_factionsAsData()
/*      */     {
/*  572 */       CrossCompete.this._xdb_verify_unsafe_();
/*      */       
/*  574 */       CrossCompete _o_ = CrossCompete.this;
/*  575 */       java.util.Set<Long> miss_turn_factions = new SetX();
/*  576 */       miss_turn_factions.addAll(_o_.miss_turn_factions);
/*  577 */       return miss_turn_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtimes(int _v_)
/*      */     {
/*  584 */       CrossCompete.this._xdb_verify_unsafe_();
/*  585 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  591 */       CrossCompete.this._xdb_verify_unsafe_();
/*  592 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  598 */       CrossCompete.this._xdb_verify_unsafe_();
/*  599 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  605 */       return CrossCompete.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  611 */       return CrossCompete.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  617 */       CrossCompete.this._xdb_verify_unsafe_();
/*  618 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  624 */       return CrossCompete.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  630 */       return CrossCompete.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  636 */       CrossCompete.this._xdb_verify_unsafe_();
/*  637 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  643 */       return CrossCompete.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  649 */       return CrossCompete.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  655 */       return CrossCompete.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  661 */       return CrossCompete.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  667 */       return CrossCompete.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  673 */       return CrossCompete.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  679 */       return CrossCompete.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.CrossCompete
/*      */   {
/*      */     private HashMap<Long, xbean.CrossCompeteSignUp> signup_factions;
/*      */     
/*      */     private int matchtimes;
/*      */     
/*      */     private HashMap<CrossCompeteMatch, xbean.CrossCompeteAgainst> againsts;
/*      */     
/*      */     private HashSet<Long> miss_turn_factions;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  702 */       this.signup_factions = new HashMap();
/*  703 */       this.matchtimes = 0;
/*  704 */       this.againsts = new HashMap();
/*  705 */       this.miss_turn_factions = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.CrossCompete _o1_)
/*      */     {
/*  710 */       if ((_o1_ instanceof CrossCompete)) { assign((CrossCompete)_o1_);
/*  711 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  712 */       } else if ((_o1_ instanceof CrossCompete.Const)) assign(((CrossCompete.Const)_o1_).nThis()); else {
/*  713 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(CrossCompete _o_) {
/*  718 */       this.signup_factions = new HashMap();
/*  719 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*  720 */         this.signup_factions.put(_e_.getKey(), new CrossCompeteSignUp.Data((xbean.CrossCompeteSignUp)_e_.getValue()));
/*  721 */       this.matchtimes = _o_.matchtimes;
/*  722 */       this.againsts = new HashMap();
/*  723 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*  724 */         this.againsts.put(_e_.getKey(), new CrossCompeteAgainst.Data((xbean.CrossCompeteAgainst)_e_.getValue()));
/*  725 */       this.miss_turn_factions = new HashSet();
/*  726 */       this.miss_turn_factions.addAll(_o_.miss_turn_factions);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  731 */       this.signup_factions = new HashMap();
/*  732 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : _o_.signup_factions.entrySet())
/*  733 */         this.signup_factions.put(_e_.getKey(), new CrossCompeteSignUp.Data((xbean.CrossCompeteSignUp)_e_.getValue()));
/*  734 */       this.matchtimes = _o_.matchtimes;
/*  735 */       this.againsts = new HashMap();
/*  736 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : _o_.againsts.entrySet())
/*  737 */         this.againsts.put(_e_.getKey(), new CrossCompeteAgainst.Data((xbean.CrossCompeteAgainst)_e_.getValue()));
/*  738 */       this.miss_turn_factions = new HashSet();
/*  739 */       this.miss_turn_factions.addAll(_o_.miss_turn_factions);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  745 */       _os_.compact_uint32(this.signup_factions.size());
/*  746 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */       {
/*  748 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  749 */         ((xbean.CrossCompeteSignUp)_e_.getValue()).marshal(_os_);
/*      */       }
/*  751 */       _os_.marshal(this.matchtimes);
/*  752 */       _os_.compact_uint32(this.againsts.size());
/*  753 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  755 */         ((CrossCompeteMatch)_e_.getKey()).marshal(_os_);
/*  756 */         ((xbean.CrossCompeteAgainst)_e_.getValue()).marshal(_os_);
/*      */       }
/*  758 */       _os_.compact_uint32(this.miss_turn_factions.size());
/*  759 */       for (Long _v_ : this.miss_turn_factions)
/*      */       {
/*  761 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  763 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  770 */       int size = _os_.uncompact_uint32();
/*  771 */       if (size >= 12)
/*      */       {
/*  773 */         this.signup_factions = new HashMap(size * 2);
/*      */       }
/*  775 */       for (; size > 0; size--)
/*      */       {
/*  777 */         long _k_ = 0L;
/*  778 */         _k_ = _os_.unmarshal_long();
/*  779 */         xbean.CrossCompeteSignUp _v_ = xbean.Pod.newCrossCompeteSignUpData();
/*  780 */         _v_.unmarshal(_os_);
/*  781 */         this.signup_factions.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  784 */       this.matchtimes = _os_.unmarshal_int();
/*      */       
/*  786 */       int size = _os_.uncompact_uint32();
/*  787 */       if (size >= 12)
/*      */       {
/*  789 */         this.againsts = new HashMap(size * 2);
/*      */       }
/*  791 */       for (; size > 0; size--)
/*      */       {
/*  793 */         CrossCompeteMatch _k_ = new CrossCompeteMatch();
/*  794 */         _k_.unmarshal(_os_);
/*  795 */         xbean.CrossCompeteAgainst _v_ = xbean.Pod.newCrossCompeteAgainstData();
/*  796 */         _v_.unmarshal(_os_);
/*  797 */         this.againsts.put(_k_, _v_);
/*      */       }
/*      */       
/*  800 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  802 */         long _v_ = 0L;
/*  803 */         _v_ = _os_.unmarshal_long();
/*  804 */         this.miss_turn_factions.add(Long.valueOf(_v_));
/*      */       }
/*  806 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  812 */       int _size_ = 0;
/*  813 */       for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */       {
/*  815 */         _size_ += CodedOutputStream.computeInt64Size(1, ((Long)_e_.getKey()).longValue());
/*  816 */         _size_ += CodedOutputStream.computeMessageSize(1, (Message)_e_.getValue());
/*      */       }
/*  818 */       _size_ += CodedOutputStream.computeInt32Size(2, this.matchtimes);
/*  819 */       for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */       {
/*  821 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getKey());
/*  822 */         _size_ += CodedOutputStream.computeMessageSize(3, (Message)_e_.getValue());
/*      */       }
/*  824 */       for (Long _v_ : this.miss_turn_factions)
/*      */       {
/*  826 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/*  828 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  836 */         for (Map.Entry<Long, xbean.CrossCompeteSignUp> _e_ : this.signup_factions.entrySet())
/*      */         {
/*  838 */           _output_.writeInt64(1, ((Long)_e_.getKey()).longValue());
/*  839 */           _output_.writeMessage(1, (Message)_e_.getValue());
/*      */         }
/*  841 */         _output_.writeInt32(2, this.matchtimes);
/*  842 */         for (Map.Entry<CrossCompeteMatch, xbean.CrossCompeteAgainst> _e_ : this.againsts.entrySet())
/*      */         {
/*  844 */           _output_.writeMessage(3, (Message)_e_.getKey());
/*  845 */           _output_.writeMessage(3, (Message)_e_.getValue());
/*      */         }
/*  847 */         for (Long _v_ : this.miss_turn_factions)
/*      */         {
/*  849 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  854 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  856 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  864 */         boolean done = false;
/*  865 */         while (!done)
/*      */         {
/*  867 */           int tag = _input_.readTag();
/*  868 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  872 */             done = true;
/*  873 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  877 */             long _k_ = 0L;
/*  878 */             _k_ = _input_.readInt64();
/*  879 */             int readTag = _input_.readTag();
/*  880 */             if (10 != readTag)
/*      */             {
/*  882 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  884 */             xbean.CrossCompeteSignUp _v_ = xbean.Pod.newCrossCompeteSignUpData();
/*  885 */             _input_.readMessage(_v_);
/*  886 */             this.signup_factions.put(Long.valueOf(_k_), _v_);
/*  887 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  891 */             this.matchtimes = _input_.readInt32();
/*  892 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/*  896 */             CrossCompeteMatch _k_ = new CrossCompeteMatch();
/*  897 */             _input_.readMessage(_k_);
/*  898 */             int readTag = _input_.readTag();
/*  899 */             if (26 != readTag)
/*      */             {
/*  901 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  903 */             xbean.CrossCompeteAgainst _v_ = xbean.Pod.newCrossCompeteAgainstData();
/*  904 */             _input_.readMessage(_v_);
/*  905 */             this.againsts.put(_k_, _v_);
/*  906 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  910 */             long _v_ = 0L;
/*  911 */             _v_ = _input_.readInt64();
/*  912 */             this.miss_turn_factions.add(Long.valueOf(_v_));
/*  913 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  917 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  919 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  928 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/*  932 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  934 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete copy()
/*      */     {
/*  940 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete toData()
/*      */     {
/*  946 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.CrossCompete toBean()
/*      */     {
/*  951 */       return new CrossCompete(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.CrossCompete toDataIf()
/*      */     {
/*  957 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.CrossCompete toBeanIf()
/*      */     {
/*  962 */       return new CrossCompete(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  972 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  980 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  988 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  992 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossCompeteSignUp> getSignup_factions()
/*      */     {
/*  999 */       return this.signup_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.CrossCompeteSignUp> getSignup_factionsAsData()
/*      */     {
/* 1006 */       return this.signup_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMatchtimes()
/*      */     {
/* 1013 */       return this.matchtimes;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainsts()
/*      */     {
/* 1020 */       return this.againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<CrossCompeteMatch, xbean.CrossCompeteAgainst> getAgainstsAsData()
/*      */     {
/* 1027 */       return this.againsts;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getMiss_turn_factions()
/*      */     {
/* 1034 */       return this.miss_turn_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public java.util.Set<Long> getMiss_turn_factionsAsData()
/*      */     {
/* 1041 */       return this.miss_turn_factions;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMatchtimes(int _v_)
/*      */     {
/* 1048 */       this.matchtimes = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1054 */       if (!(_o1_ instanceof Data)) return false;
/* 1055 */       Data _o_ = (Data)_o1_;
/* 1056 */       if (!this.signup_factions.equals(_o_.signup_factions)) return false;
/* 1057 */       if (this.matchtimes != _o_.matchtimes) return false;
/* 1058 */       if (!this.againsts.equals(_o_.againsts)) return false;
/* 1059 */       if (!this.miss_turn_factions.equals(_o_.miss_turn_factions)) return false;
/* 1060 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1066 */       int _h_ = 0;
/* 1067 */       _h_ += this.signup_factions.hashCode();
/* 1068 */       _h_ += this.matchtimes;
/* 1069 */       _h_ += this.againsts.hashCode();
/* 1070 */       _h_ += this.miss_turn_factions.hashCode();
/* 1071 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1077 */       StringBuilder _sb_ = new StringBuilder();
/* 1078 */       _sb_.append("(");
/* 1079 */       _sb_.append(this.signup_factions);
/* 1080 */       _sb_.append(",");
/* 1081 */       _sb_.append(this.matchtimes);
/* 1082 */       _sb_.append(",");
/* 1083 */       _sb_.append(this.againsts);
/* 1084 */       _sb_.append(",");
/* 1085 */       _sb_.append(this.miss_turn_factions);
/* 1086 */       _sb_.append(")");
/* 1087 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CrossCompete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */