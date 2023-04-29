/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class RoundRobinFightBetInfo extends XBean implements xbean.RoundRobinFightBetInfo
/*      */ {
/*      */   private long corps_a_id;
/*      */   private long corps_b_id;
/*      */   private long corps_a_bet_money_sum;
/*      */   private long corps_b_bet_money_sum;
/*      */   private HashMap<Long, xbean.RoleRoundRobinFightBetInfo> role_bet_infos;
/*      */   private int state;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.corps_a_id = 0L;
/*   29 */     this.corps_b_id = 0L;
/*   30 */     this.corps_a_bet_money_sum = 0L;
/*   31 */     this.corps_b_bet_money_sum = 0L;
/*   32 */     this.role_bet_infos.clear();
/*   33 */     this.state = 0;
/*      */   }
/*      */   
/*      */   RoundRobinFightBetInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.corps_a_bet_money_sum = 0L;
/*   40 */     this.corps_b_bet_money_sum = 0L;
/*   41 */     this.role_bet_infos = new HashMap();
/*      */   }
/*      */   
/*      */   public RoundRobinFightBetInfo()
/*      */   {
/*   46 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoundRobinFightBetInfo(RoundRobinFightBetInfo _o_)
/*      */   {
/*   51 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoundRobinFightBetInfo(xbean.RoundRobinFightBetInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   56 */     super(_xp_, _vn_);
/*   57 */     if ((_o1_ instanceof RoundRobinFightBetInfo)) { assign((RoundRobinFightBetInfo)_o1_);
/*   58 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   59 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   60 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoundRobinFightBetInfo _o_) {
/*   65 */     _o_._xdb_verify_unsafe_();
/*   66 */     this.corps_a_id = _o_.corps_a_id;
/*   67 */     this.corps_b_id = _o_.corps_b_id;
/*   68 */     this.corps_a_bet_money_sum = _o_.corps_a_bet_money_sum;
/*   69 */     this.corps_b_bet_money_sum = _o_.corps_b_bet_money_sum;
/*   70 */     this.role_bet_infos = new HashMap();
/*   71 */     for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*   72 */       this.role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo((xbean.RoleRoundRobinFightBetInfo)_e_.getValue(), this, "role_bet_infos"));
/*   73 */     this.state = _o_.state;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.corps_a_id = _o_.corps_a_id;
/*   79 */     this.corps_b_id = _o_.corps_b_id;
/*   80 */     this.corps_a_bet_money_sum = _o_.corps_a_bet_money_sum;
/*   81 */     this.corps_b_bet_money_sum = _o_.corps_b_bet_money_sum;
/*   82 */     this.role_bet_infos = new HashMap();
/*   83 */     for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*   84 */       this.role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo((xbean.RoleRoundRobinFightBetInfo)_e_.getValue(), this, "role_bet_infos"));
/*   85 */     this.state = _o_.state;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   91 */     _xdb_verify_unsafe_();
/*   92 */     _os_.marshal(this.corps_a_id);
/*   93 */     _os_.marshal(this.corps_b_id);
/*   94 */     _os_.marshal(this.corps_a_bet_money_sum);
/*   95 */     _os_.marshal(this.corps_b_bet_money_sum);
/*   96 */     _os_.compact_uint32(this.role_bet_infos.size());
/*   97 */     for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */     {
/*   99 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  100 */       ((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  102 */     _os_.marshal(this.state);
/*  103 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  109 */     _xdb_verify_unsafe_();
/*  110 */     this.corps_a_id = _os_.unmarshal_long();
/*  111 */     this.corps_b_id = _os_.unmarshal_long();
/*  112 */     this.corps_a_bet_money_sum = _os_.unmarshal_long();
/*  113 */     this.corps_b_bet_money_sum = _os_.unmarshal_long();
/*      */     
/*  115 */     int size = _os_.uncompact_uint32();
/*  116 */     if (size >= 12)
/*      */     {
/*  118 */       this.role_bet_infos = new HashMap(size * 2);
/*      */     }
/*  120 */     for (; size > 0; size--)
/*      */     {
/*  122 */       long _k_ = 0L;
/*  123 */       _k_ = _os_.unmarshal_long();
/*  124 */       xbean.RoleRoundRobinFightBetInfo _v_ = new RoleRoundRobinFightBetInfo(0, this, "role_bet_infos");
/*  125 */       _v_.unmarshal(_os_);
/*  126 */       this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  129 */     this.state = _os_.unmarshal_int();
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(1, this.corps_a_id);
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(2, this.corps_b_id);
/*  140 */     _size_ += CodedOutputStream.computeInt64Size(3, this.corps_a_bet_money_sum);
/*  141 */     _size_ += CodedOutputStream.computeInt64Size(4, this.corps_b_bet_money_sum);
/*  142 */     for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */     {
/*  144 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  145 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(6, this.state);
/*  148 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  154 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  157 */       _output_.writeInt64(1, this.corps_a_id);
/*  158 */       _output_.writeInt64(2, this.corps_b_id);
/*  159 */       _output_.writeInt64(3, this.corps_a_bet_money_sum);
/*  160 */       _output_.writeInt64(4, this.corps_b_bet_money_sum);
/*  161 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  163 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  164 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  166 */       _output_.writeInt32(6, this.state);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  170 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  172 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  178 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  181 */       boolean done = false;
/*  182 */       while (!done)
/*      */       {
/*  184 */         int tag = _input_.readTag();
/*  185 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  189 */           done = true;
/*  190 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  194 */           this.corps_a_id = _input_.readInt64();
/*  195 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  199 */           this.corps_b_id = _input_.readInt64();
/*  200 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  204 */           this.corps_a_bet_money_sum = _input_.readInt64();
/*  205 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  209 */           this.corps_b_bet_money_sum = _input_.readInt64();
/*  210 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  214 */           long _k_ = 0L;
/*  215 */           _k_ = _input_.readInt64();
/*  216 */           int readTag = _input_.readTag();
/*  217 */           if (42 != readTag)
/*      */           {
/*  219 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  221 */           xbean.RoleRoundRobinFightBetInfo _v_ = new RoleRoundRobinFightBetInfo(0, this, "role_bet_infos");
/*  222 */           _input_.readMessage(_v_);
/*  223 */           this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  228 */           this.state = _input_.readInt32();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  233 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  235 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  244 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  248 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  250 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightBetInfo copy()
/*      */   {
/*  256 */     _xdb_verify_unsafe_();
/*  257 */     return new RoundRobinFightBetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightBetInfo toData()
/*      */   {
/*  263 */     _xdb_verify_unsafe_();
/*  264 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoundRobinFightBetInfo toBean()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new RoundRobinFightBetInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoundRobinFightBetInfo toDataIf()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoundRobinFightBetInfo toBeanIf()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  289 */     _xdb_verify_unsafe_();
/*  290 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_a_id()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this.corps_a_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_b_id()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this.corps_b_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_a_bet_money_sum()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this.corps_a_bet_money_sum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCorps_b_bet_money_sum()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return this.corps_b_bet_money_sum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infos()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return xdb.Logs.logMap(new LogKey(this, "role_bet_infos"), this.role_bet_infos);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infosAsData()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*      */     
/*  339 */     RoundRobinFightBetInfo _o_ = this;
/*  340 */     Map<Long, xbean.RoleRoundRobinFightBetInfo> role_bet_infos = new HashMap();
/*  341 */     for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  342 */       role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo.Data((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()));
/*  343 */     return role_bet_infos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getState()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return this.state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_a_id(long _v_)
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     xdb.Logs.logIf(new LogKey(this, "corps_a_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  363 */         new LogLong(this, RoundRobinFightBetInfo.this.corps_a_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  367 */             RoundRobinFightBetInfo.this.corps_a_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  371 */     });
/*  372 */     this.corps_a_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_b_id(long _v_)
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     xdb.Logs.logIf(new LogKey(this, "corps_b_id")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  384 */         new LogLong(this, RoundRobinFightBetInfo.this.corps_b_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  388 */             RoundRobinFightBetInfo.this.corps_b_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  392 */     });
/*  393 */     this.corps_b_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_a_bet_money_sum(long _v_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     xdb.Logs.logIf(new LogKey(this, "corps_a_bet_money_sum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  405 */         new LogLong(this, RoundRobinFightBetInfo.this.corps_a_bet_money_sum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  409 */             RoundRobinFightBetInfo.this.corps_a_bet_money_sum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  413 */     });
/*  414 */     this.corps_a_bet_money_sum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCorps_b_bet_money_sum(long _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     xdb.Logs.logIf(new LogKey(this, "corps_b_bet_money_sum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  426 */         new LogLong(this, RoundRobinFightBetInfo.this.corps_b_bet_money_sum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             RoundRobinFightBetInfo.this.corps_b_bet_money_sum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.corps_b_bet_money_sum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setState(int _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     xdb.Logs.logIf(new LogKey(this, "state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  447 */         new xdb.logs.LogInt(this, RoundRobinFightBetInfo.this.state)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  451 */             RoundRobinFightBetInfo.this.state = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  455 */     });
/*  456 */     this.state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  462 */     _xdb_verify_unsafe_();
/*  463 */     RoundRobinFightBetInfo _o_ = null;
/*  464 */     if ((_o1_ instanceof RoundRobinFightBetInfo)) { _o_ = (RoundRobinFightBetInfo)_o1_;
/*  465 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  466 */       return false;
/*  467 */     if (this.corps_a_id != _o_.corps_a_id) return false;
/*  468 */     if (this.corps_b_id != _o_.corps_b_id) return false;
/*  469 */     if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/*  470 */     if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/*  471 */     if (!this.role_bet_infos.equals(_o_.role_bet_infos)) return false;
/*  472 */     if (this.state != _o_.state) return false;
/*  473 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     int _h_ = 0;
/*  481 */     _h_ = (int)(_h_ + this.corps_a_id);
/*  482 */     _h_ = (int)(_h_ + this.corps_b_id);
/*  483 */     _h_ = (int)(_h_ + this.corps_a_bet_money_sum);
/*  484 */     _h_ = (int)(_h_ + this.corps_b_bet_money_sum);
/*  485 */     _h_ += this.role_bet_infos.hashCode();
/*  486 */     _h_ += this.state;
/*  487 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     StringBuilder _sb_ = new StringBuilder();
/*  495 */     _sb_.append("(");
/*  496 */     _sb_.append(this.corps_a_id);
/*  497 */     _sb_.append(",");
/*  498 */     _sb_.append(this.corps_b_id);
/*  499 */     _sb_.append(",");
/*  500 */     _sb_.append(this.corps_a_bet_money_sum);
/*  501 */     _sb_.append(",");
/*  502 */     _sb_.append(this.corps_b_bet_money_sum);
/*  503 */     _sb_.append(",");
/*  504 */     _sb_.append(this.role_bet_infos);
/*  505 */     _sb_.append(",");
/*  506 */     _sb_.append(this.state);
/*  507 */     _sb_.append(")");
/*  508 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  514 */     ListenableBean lb = new ListenableBean();
/*  515 */     lb.add(new ListenableChanged().setVarName("corps_a_id"));
/*  516 */     lb.add(new ListenableChanged().setVarName("corps_b_id"));
/*  517 */     lb.add(new ListenableChanged().setVarName("corps_a_bet_money_sum"));
/*  518 */     lb.add(new ListenableChanged().setVarName("corps_b_bet_money_sum"));
/*  519 */     lb.add(new xdb.logs.ListenableMap().setVarName("role_bet_infos"));
/*  520 */     lb.add(new ListenableChanged().setVarName("state"));
/*  521 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoundRobinFightBetInfo {
/*      */     private Const() {}
/*      */     
/*      */     RoundRobinFightBetInfo nThis() {
/*  528 */       return RoundRobinFightBetInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  534 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo copy()
/*      */     {
/*  540 */       return RoundRobinFightBetInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo toData()
/*      */     {
/*  546 */       return RoundRobinFightBetInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightBetInfo toBean()
/*      */     {
/*  551 */       return RoundRobinFightBetInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo toDataIf()
/*      */     {
/*  557 */       return RoundRobinFightBetInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightBetInfo toBeanIf()
/*      */     {
/*  562 */       return RoundRobinFightBetInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_id()
/*      */     {
/*  569 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  570 */       return RoundRobinFightBetInfo.this.corps_a_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_id()
/*      */     {
/*  577 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  578 */       return RoundRobinFightBetInfo.this.corps_b_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_bet_money_sum()
/*      */     {
/*  585 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  586 */       return RoundRobinFightBetInfo.this.corps_a_bet_money_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_bet_money_sum()
/*      */     {
/*  593 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  594 */       return RoundRobinFightBetInfo.this.corps_b_bet_money_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infos()
/*      */     {
/*  601 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  602 */       return xdb.Consts.constMap(RoundRobinFightBetInfo.this.role_bet_infos);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infosAsData()
/*      */     {
/*  609 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*      */       
/*  611 */       RoundRobinFightBetInfo _o_ = RoundRobinFightBetInfo.this;
/*  612 */       Map<Long, xbean.RoleRoundRobinFightBetInfo> role_bet_infos = new HashMap();
/*  613 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  614 */         role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo.Data((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()));
/*  615 */       return role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/*  622 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  623 */       return RoundRobinFightBetInfo.this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_id(long _v_)
/*      */     {
/*  630 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  631 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_id(long _v_)
/*      */     {
/*  638 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_bet_money_sum(long _v_)
/*      */     {
/*  646 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_bet_money_sum(long _v_)
/*      */     {
/*  654 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  655 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/*  662 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  663 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  669 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  670 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  676 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  677 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  683 */       return RoundRobinFightBetInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  689 */       return RoundRobinFightBetInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  695 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  696 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  702 */       return RoundRobinFightBetInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  708 */       return RoundRobinFightBetInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  714 */       RoundRobinFightBetInfo.this._xdb_verify_unsafe_();
/*  715 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  721 */       return RoundRobinFightBetInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  727 */       return RoundRobinFightBetInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  733 */       return RoundRobinFightBetInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  739 */       return RoundRobinFightBetInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  745 */       return RoundRobinFightBetInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  751 */       return RoundRobinFightBetInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  757 */       return RoundRobinFightBetInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoundRobinFightBetInfo
/*      */   {
/*      */     private long corps_a_id;
/*      */     
/*      */     private long corps_b_id;
/*      */     
/*      */     private long corps_a_bet_money_sum;
/*      */     
/*      */     private long corps_b_bet_money_sum;
/*      */     
/*      */     private HashMap<Long, xbean.RoleRoundRobinFightBetInfo> role_bet_infos;
/*      */     
/*      */     private int state;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  784 */       this.corps_a_bet_money_sum = 0L;
/*  785 */       this.corps_b_bet_money_sum = 0L;
/*  786 */       this.role_bet_infos = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.RoundRobinFightBetInfo _o1_)
/*      */     {
/*  791 */       if ((_o1_ instanceof RoundRobinFightBetInfo)) { assign((RoundRobinFightBetInfo)_o1_);
/*  792 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  793 */       } else if ((_o1_ instanceof RoundRobinFightBetInfo.Const)) assign(((RoundRobinFightBetInfo.Const)_o1_).nThis()); else {
/*  794 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoundRobinFightBetInfo _o_) {
/*  799 */       this.corps_a_id = _o_.corps_a_id;
/*  800 */       this.corps_b_id = _o_.corps_b_id;
/*  801 */       this.corps_a_bet_money_sum = _o_.corps_a_bet_money_sum;
/*  802 */       this.corps_b_bet_money_sum = _o_.corps_b_bet_money_sum;
/*  803 */       this.role_bet_infos = new HashMap();
/*  804 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  805 */         this.role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo.Data((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()));
/*  806 */       this.state = _o_.state;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  811 */       this.corps_a_id = _o_.corps_a_id;
/*  812 */       this.corps_b_id = _o_.corps_b_id;
/*  813 */       this.corps_a_bet_money_sum = _o_.corps_a_bet_money_sum;
/*  814 */       this.corps_b_bet_money_sum = _o_.corps_b_bet_money_sum;
/*  815 */       this.role_bet_infos = new HashMap();
/*  816 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : _o_.role_bet_infos.entrySet())
/*  817 */         this.role_bet_infos.put(_e_.getKey(), new RoleRoundRobinFightBetInfo.Data((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()));
/*  818 */       this.state = _o_.state;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  824 */       _os_.marshal(this.corps_a_id);
/*  825 */       _os_.marshal(this.corps_b_id);
/*  826 */       _os_.marshal(this.corps_a_bet_money_sum);
/*  827 */       _os_.marshal(this.corps_b_bet_money_sum);
/*  828 */       _os_.compact_uint32(this.role_bet_infos.size());
/*  829 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  831 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  832 */         ((xbean.RoleRoundRobinFightBetInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  834 */       _os_.marshal(this.state);
/*  835 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  841 */       this.corps_a_id = _os_.unmarshal_long();
/*  842 */       this.corps_b_id = _os_.unmarshal_long();
/*  843 */       this.corps_a_bet_money_sum = _os_.unmarshal_long();
/*  844 */       this.corps_b_bet_money_sum = _os_.unmarshal_long();
/*      */       
/*  846 */       int size = _os_.uncompact_uint32();
/*  847 */       if (size >= 12)
/*      */       {
/*  849 */         this.role_bet_infos = new HashMap(size * 2);
/*      */       }
/*  851 */       for (; size > 0; size--)
/*      */       {
/*  853 */         long _k_ = 0L;
/*  854 */         _k_ = _os_.unmarshal_long();
/*  855 */         xbean.RoleRoundRobinFightBetInfo _v_ = xbean.Pod.newRoleRoundRobinFightBetInfoData();
/*  856 */         _v_.unmarshal(_os_);
/*  857 */         this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  860 */       this.state = _os_.unmarshal_int();
/*  861 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  867 */       int _size_ = 0;
/*  868 */       _size_ += CodedOutputStream.computeInt64Size(1, this.corps_a_id);
/*  869 */       _size_ += CodedOutputStream.computeInt64Size(2, this.corps_b_id);
/*  870 */       _size_ += CodedOutputStream.computeInt64Size(3, this.corps_a_bet_money_sum);
/*  871 */       _size_ += CodedOutputStream.computeInt64Size(4, this.corps_b_bet_money_sum);
/*  872 */       for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */       {
/*  874 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  875 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  877 */       _size_ += CodedOutputStream.computeInt32Size(6, this.state);
/*  878 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  886 */         _output_.writeInt64(1, this.corps_a_id);
/*  887 */         _output_.writeInt64(2, this.corps_b_id);
/*  888 */         _output_.writeInt64(3, this.corps_a_bet_money_sum);
/*  889 */         _output_.writeInt64(4, this.corps_b_bet_money_sum);
/*  890 */         for (Map.Entry<Long, xbean.RoleRoundRobinFightBetInfo> _e_ : this.role_bet_infos.entrySet())
/*      */         {
/*  892 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  893 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/*  895 */         _output_.writeInt32(6, this.state);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  899 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  901 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  909 */         boolean done = false;
/*  910 */         while (!done)
/*      */         {
/*  912 */           int tag = _input_.readTag();
/*  913 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  917 */             done = true;
/*  918 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  922 */             this.corps_a_id = _input_.readInt64();
/*  923 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  927 */             this.corps_b_id = _input_.readInt64();
/*  928 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  932 */             this.corps_a_bet_money_sum = _input_.readInt64();
/*  933 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  937 */             this.corps_b_bet_money_sum = _input_.readInt64();
/*  938 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  942 */             long _k_ = 0L;
/*  943 */             _k_ = _input_.readInt64();
/*  944 */             int readTag = _input_.readTag();
/*  945 */             if (42 != readTag)
/*      */             {
/*  947 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  949 */             xbean.RoleRoundRobinFightBetInfo _v_ = xbean.Pod.newRoleRoundRobinFightBetInfoData();
/*  950 */             _input_.readMessage(_v_);
/*  951 */             this.role_bet_infos.put(Long.valueOf(_k_), _v_);
/*  952 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  956 */             this.state = _input_.readInt32();
/*  957 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  961 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  963 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  972 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  976 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  978 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo copy()
/*      */     {
/*  984 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo toData()
/*      */     {
/*  990 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightBetInfo toBean()
/*      */     {
/*  995 */       return new RoundRobinFightBetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoundRobinFightBetInfo toDataIf()
/*      */     {
/* 1001 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoundRobinFightBetInfo toBeanIf()
/*      */     {
/* 1006 */       return new RoundRobinFightBetInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1012 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1016 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1020 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1028 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1032 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1036 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_id()
/*      */     {
/* 1043 */       return this.corps_a_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_id()
/*      */     {
/* 1050 */       return this.corps_b_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_a_bet_money_sum()
/*      */     {
/* 1057 */       return this.corps_a_bet_money_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCorps_b_bet_money_sum()
/*      */     {
/* 1064 */       return this.corps_b_bet_money_sum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infos()
/*      */     {
/* 1071 */       return this.role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.RoleRoundRobinFightBetInfo> getRole_bet_infosAsData()
/*      */     {
/* 1078 */       return this.role_bet_infos;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getState()
/*      */     {
/* 1085 */       return this.state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_id(long _v_)
/*      */     {
/* 1092 */       this.corps_a_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_id(long _v_)
/*      */     {
/* 1099 */       this.corps_b_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_a_bet_money_sum(long _v_)
/*      */     {
/* 1106 */       this.corps_a_bet_money_sum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCorps_b_bet_money_sum(long _v_)
/*      */     {
/* 1113 */       this.corps_b_bet_money_sum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setState(int _v_)
/*      */     {
/* 1120 */       this.state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1126 */       if (!(_o1_ instanceof Data)) return false;
/* 1127 */       Data _o_ = (Data)_o1_;
/* 1128 */       if (this.corps_a_id != _o_.corps_a_id) return false;
/* 1129 */       if (this.corps_b_id != _o_.corps_b_id) return false;
/* 1130 */       if (this.corps_a_bet_money_sum != _o_.corps_a_bet_money_sum) return false;
/* 1131 */       if (this.corps_b_bet_money_sum != _o_.corps_b_bet_money_sum) return false;
/* 1132 */       if (!this.role_bet_infos.equals(_o_.role_bet_infos)) return false;
/* 1133 */       if (this.state != _o_.state) return false;
/* 1134 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1140 */       int _h_ = 0;
/* 1141 */       _h_ = (int)(_h_ + this.corps_a_id);
/* 1142 */       _h_ = (int)(_h_ + this.corps_b_id);
/* 1143 */       _h_ = (int)(_h_ + this.corps_a_bet_money_sum);
/* 1144 */       _h_ = (int)(_h_ + this.corps_b_bet_money_sum);
/* 1145 */       _h_ += this.role_bet_infos.hashCode();
/* 1146 */       _h_ += this.state;
/* 1147 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1153 */       StringBuilder _sb_ = new StringBuilder();
/* 1154 */       _sb_.append("(");
/* 1155 */       _sb_.append(this.corps_a_id);
/* 1156 */       _sb_.append(",");
/* 1157 */       _sb_.append(this.corps_b_id);
/* 1158 */       _sb_.append(",");
/* 1159 */       _sb_.append(this.corps_a_bet_money_sum);
/* 1160 */       _sb_.append(",");
/* 1161 */       _sb_.append(this.corps_b_bet_money_sum);
/* 1162 */       _sb_.append(",");
/* 1163 */       _sb_.append(this.role_bet_infos);
/* 1164 */       _sb_.append(",");
/* 1165 */       _sb_.append(this.state);
/* 1166 */       _sb_.append(")");
/* 1167 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoundRobinFightBetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */