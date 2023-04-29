/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class RoamCrossCompeteFaction extends XBean implements xbean.RoamCrossCompeteFaction
/*      */ {
/*      */   private String name;
/*      */   private HashMap<Integer, xbean.GangDutyMembers> duty2members;
/*      */   private int designed_titleid;
/*      */   private long opponent;
/*      */   private int pk_score;
/*      */   private int player_score;
/*      */   private int win_times;
/*      */   private int max_member_count;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   32 */     this.name = "";
/*   33 */     this.duty2members.clear();
/*   34 */     this.designed_titleid = 0;
/*   35 */     this.opponent = 0L;
/*   36 */     this.pk_score = 0;
/*   37 */     this.player_score = 0;
/*   38 */     this.win_times = 0;
/*   39 */     this.max_member_count = 0;
/*      */   }
/*      */   
/*      */   RoamCrossCompeteFaction(int __, XBean _xp_, String _vn_)
/*      */   {
/*   44 */     super(_xp_, _vn_);
/*   45 */     this.name = "";
/*   46 */     this.duty2members = new HashMap();
/*   47 */     this.pk_score = 0;
/*   48 */     this.player_score = 0;
/*   49 */     this.win_times = 0;
/*   50 */     this.max_member_count = 0;
/*      */   }
/*      */   
/*      */   public RoamCrossCompeteFaction()
/*      */   {
/*   55 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoamCrossCompeteFaction(RoamCrossCompeteFaction _o_)
/*      */   {
/*   60 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoamCrossCompeteFaction(xbean.RoamCrossCompeteFaction _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   65 */     super(_xp_, _vn_);
/*   66 */     if ((_o1_ instanceof RoamCrossCompeteFaction)) { assign((RoamCrossCompeteFaction)_o1_);
/*   67 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   68 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   69 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoamCrossCompeteFaction _o_) {
/*   74 */     _o_._xdb_verify_unsafe_();
/*   75 */     this.name = _o_.name;
/*   76 */     this.duty2members = new HashMap();
/*   77 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*   78 */       this.duty2members.put(_e_.getKey(), new GangDutyMembers((xbean.GangDutyMembers)_e_.getValue(), this, "duty2members"));
/*   79 */     this.designed_titleid = _o_.designed_titleid;
/*   80 */     this.opponent = _o_.opponent;
/*   81 */     this.pk_score = _o_.pk_score;
/*   82 */     this.player_score = _o_.player_score;
/*   83 */     this.win_times = _o_.win_times;
/*   84 */     this.max_member_count = _o_.max_member_count;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   89 */     this.name = _o_.name;
/*   90 */     this.duty2members = new HashMap();
/*   91 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*   92 */       this.duty2members.put(_e_.getKey(), new GangDutyMembers((xbean.GangDutyMembers)_e_.getValue(), this, "duty2members"));
/*   93 */     this.designed_titleid = _o_.designed_titleid;
/*   94 */     this.opponent = _o_.opponent;
/*   95 */     this.pk_score = _o_.pk_score;
/*   96 */     this.player_score = _o_.player_score;
/*   97 */     this.win_times = _o_.win_times;
/*   98 */     this.max_member_count = _o_.max_member_count;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     _os_.marshal(this.name, "UTF-16LE");
/*  106 */     _os_.compact_uint32(this.duty2members.size());
/*  107 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  109 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  110 */       ((xbean.GangDutyMembers)_e_.getValue()).marshal(_os_);
/*      */     }
/*  112 */     _os_.marshal(this.designed_titleid);
/*  113 */     _os_.marshal(this.opponent);
/*  114 */     _os_.marshal(this.pk_score);
/*  115 */     _os_.marshal(this.player_score);
/*  116 */     _os_.marshal(this.win_times);
/*  117 */     _os_.marshal(this.max_member_count);
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     this.name = _os_.unmarshal_String("UTF-16LE");
/*      */     
/*  127 */     int size = _os_.uncompact_uint32();
/*  128 */     if (size >= 12)
/*      */     {
/*  130 */       this.duty2members = new HashMap(size * 2);
/*      */     }
/*  132 */     for (; size > 0; size--)
/*      */     {
/*  134 */       int _k_ = 0;
/*  135 */       _k_ = _os_.unmarshal_int();
/*  136 */       xbean.GangDutyMembers _v_ = new GangDutyMembers(0, this, "duty2members");
/*  137 */       _v_.unmarshal(_os_);
/*  138 */       this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  141 */     this.designed_titleid = _os_.unmarshal_int();
/*  142 */     this.opponent = _os_.unmarshal_long();
/*  143 */     this.pk_score = _os_.unmarshal_int();
/*  144 */     this.player_score = _os_.unmarshal_int();
/*  145 */     this.win_times = _os_.unmarshal_int();
/*  146 */     this.max_member_count = _os_.unmarshal_int();
/*  147 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  153 */     _xdb_verify_unsafe_();
/*  154 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  157 */       _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  161 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  163 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */     {
/*  165 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  166 */       _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */     }
/*  168 */     _size_ += CodedOutputStream.computeInt32Size(3, this.designed_titleid);
/*  169 */     _size_ += CodedOutputStream.computeInt64Size(4, this.opponent);
/*  170 */     _size_ += CodedOutputStream.computeInt32Size(5, this.pk_score);
/*  171 */     _size_ += CodedOutputStream.computeInt32Size(6, this.player_score);
/*  172 */     _size_ += CodedOutputStream.computeInt32Size(7, this.win_times);
/*  173 */     _size_ += CodedOutputStream.computeInt32Size(8, this.max_member_count);
/*  174 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  180 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  183 */       _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*  184 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/*  186 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  187 */         _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */       }
/*  189 */       _output_.writeInt32(3, this.designed_titleid);
/*  190 */       _output_.writeInt64(4, this.opponent);
/*  191 */       _output_.writeInt32(5, this.pk_score);
/*  192 */       _output_.writeInt32(6, this.player_score);
/*  193 */       _output_.writeInt32(7, this.win_times);
/*  194 */       _output_.writeInt32(8, this.max_member_count);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  198 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  200 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  206 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  209 */       boolean done = false;
/*  210 */       while (!done)
/*      */       {
/*  212 */         int tag = _input_.readTag();
/*  213 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  217 */           done = true;
/*  218 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  222 */           this.name = _input_.readBytes().toString("UTF-16LE");
/*  223 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  227 */           int _k_ = 0;
/*  228 */           _k_ = _input_.readInt32();
/*  229 */           int readTag = _input_.readTag();
/*  230 */           if (18 != readTag)
/*      */           {
/*  232 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  234 */           xbean.GangDutyMembers _v_ = new GangDutyMembers(0, this, "duty2members");
/*  235 */           _input_.readMessage(_v_);
/*  236 */           this.duty2members.put(Integer.valueOf(_k_), _v_);
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  241 */           this.designed_titleid = _input_.readInt32();
/*  242 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  246 */           this.opponent = _input_.readInt64();
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  251 */           this.pk_score = _input_.readInt32();
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  256 */           this.player_score = _input_.readInt32();
/*  257 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  261 */           this.win_times = _input_.readInt32();
/*  262 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  266 */           this.max_member_count = _input_.readInt32();
/*  267 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  271 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  273 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  282 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  286 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  288 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteFaction copy()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new RoamCrossCompeteFaction(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteFaction toData()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoamCrossCompeteFaction toBean()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new RoamCrossCompeteFaction(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoamCrossCompeteFaction toDataIf()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoamCrossCompeteFaction toBeanIf()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.name;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getNameOctets()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return Octets.wrap(getName(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return Logs.logMap(new LogKey(this, "duty2members"), this.duty2members);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*      */     
/*  361 */     RoamCrossCompeteFaction _o_ = this;
/*  362 */     Map<Integer, xbean.GangDutyMembers> duty2members = new HashMap();
/*  363 */     for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  364 */       duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/*  365 */     return duty2members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDesigned_titleid()
/*      */   {
/*  372 */     _xdb_verify_unsafe_();
/*  373 */     return this.designed_titleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpponent()
/*      */   {
/*  380 */     _xdb_verify_unsafe_();
/*  381 */     return this.opponent;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPk_score()
/*      */   {
/*  388 */     _xdb_verify_unsafe_();
/*  389 */     return this.pk_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPlayer_score()
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     return this.player_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  404 */     _xdb_verify_unsafe_();
/*  405 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMax_member_count()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     return this.max_member_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName(String _v_)
/*      */   {
/*  420 */     _xdb_verify_unsafe_();
/*  421 */     if (null == _v_)
/*  422 */       throw new NullPointerException();
/*  423 */     Logs.logIf(new LogKey(this, "name")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  427 */         new xdb.logs.LogString(this, RoamCrossCompeteFaction.this.name)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  431 */             RoamCrossCompeteFaction.this.name = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  435 */     });
/*  436 */     this.name = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNameOctets(Octets _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     setName(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDesigned_titleid(int _v_)
/*      */   {
/*  451 */     _xdb_verify_unsafe_();
/*  452 */     Logs.logIf(new LogKey(this, "designed_titleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  456 */         new LogInt(this, RoamCrossCompeteFaction.this.designed_titleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             RoamCrossCompeteFaction.this.designed_titleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.designed_titleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpponent(long _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     Logs.logIf(new LogKey(this, "opponent")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  477 */         new xdb.logs.LogLong(this, RoamCrossCompeteFaction.this.opponent)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  481 */             RoamCrossCompeteFaction.this.opponent = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  485 */     });
/*  486 */     this.opponent = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPk_score(int _v_)
/*      */   {
/*  493 */     _xdb_verify_unsafe_();
/*  494 */     Logs.logIf(new LogKey(this, "pk_score")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  498 */         new LogInt(this, RoamCrossCompeteFaction.this.pk_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  502 */             RoamCrossCompeteFaction.this.pk_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  506 */     });
/*  507 */     this.pk_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_score(int _v_)
/*      */   {
/*  514 */     _xdb_verify_unsafe_();
/*  515 */     Logs.logIf(new LogKey(this, "player_score")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  519 */         new LogInt(this, RoamCrossCompeteFaction.this.player_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  523 */             RoamCrossCompeteFaction.this.player_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  527 */     });
/*  528 */     this.player_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  535 */     _xdb_verify_unsafe_();
/*  536 */     Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  540 */         new LogInt(this, RoamCrossCompeteFaction.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  544 */             RoamCrossCompeteFaction.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  548 */     });
/*  549 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMax_member_count(int _v_)
/*      */   {
/*  556 */     _xdb_verify_unsafe_();
/*  557 */     Logs.logIf(new LogKey(this, "max_member_count")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  561 */         new LogInt(this, RoamCrossCompeteFaction.this.max_member_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  565 */             RoamCrossCompeteFaction.this.max_member_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  569 */     });
/*  570 */     this.max_member_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  576 */     _xdb_verify_unsafe_();
/*  577 */     RoamCrossCompeteFaction _o_ = null;
/*  578 */     if ((_o1_ instanceof RoamCrossCompeteFaction)) { _o_ = (RoamCrossCompeteFaction)_o1_;
/*  579 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  580 */       return false;
/*  581 */     if (!this.name.equals(_o_.name)) return false;
/*  582 */     if (!this.duty2members.equals(_o_.duty2members)) return false;
/*  583 */     if (this.designed_titleid != _o_.designed_titleid) return false;
/*  584 */     if (this.opponent != _o_.opponent) return false;
/*  585 */     if (this.pk_score != _o_.pk_score) return false;
/*  586 */     if (this.player_score != _o_.player_score) return false;
/*  587 */     if (this.win_times != _o_.win_times) return false;
/*  588 */     if (this.max_member_count != _o_.max_member_count) return false;
/*  589 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  595 */     _xdb_verify_unsafe_();
/*  596 */     int _h_ = 0;
/*  597 */     _h_ += this.name.hashCode();
/*  598 */     _h_ += this.duty2members.hashCode();
/*  599 */     _h_ += this.designed_titleid;
/*  600 */     _h_ = (int)(_h_ + this.opponent);
/*  601 */     _h_ += this.pk_score;
/*  602 */     _h_ += this.player_score;
/*  603 */     _h_ += this.win_times;
/*  604 */     _h_ += this.max_member_count;
/*  605 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  611 */     _xdb_verify_unsafe_();
/*  612 */     StringBuilder _sb_ = new StringBuilder();
/*  613 */     _sb_.append("(");
/*  614 */     _sb_.append("'").append(this.name).append("'");
/*  615 */     _sb_.append(",");
/*  616 */     _sb_.append(this.duty2members);
/*  617 */     _sb_.append(",");
/*  618 */     _sb_.append(this.designed_titleid);
/*  619 */     _sb_.append(",");
/*  620 */     _sb_.append(this.opponent);
/*  621 */     _sb_.append(",");
/*  622 */     _sb_.append(this.pk_score);
/*  623 */     _sb_.append(",");
/*  624 */     _sb_.append(this.player_score);
/*  625 */     _sb_.append(",");
/*  626 */     _sb_.append(this.win_times);
/*  627 */     _sb_.append(",");
/*  628 */     _sb_.append(this.max_member_count);
/*  629 */     _sb_.append(")");
/*  630 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  636 */     ListenableBean lb = new ListenableBean();
/*  637 */     lb.add(new ListenableChanged().setVarName("name"));
/*  638 */     lb.add(new xdb.logs.ListenableMap().setVarName("duty2members"));
/*  639 */     lb.add(new ListenableChanged().setVarName("designed_titleid"));
/*  640 */     lb.add(new ListenableChanged().setVarName("opponent"));
/*  641 */     lb.add(new ListenableChanged().setVarName("pk_score"));
/*  642 */     lb.add(new ListenableChanged().setVarName("player_score"));
/*  643 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  644 */     lb.add(new ListenableChanged().setVarName("max_member_count"));
/*  645 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoamCrossCompeteFaction {
/*      */     private Const() {}
/*      */     
/*      */     RoamCrossCompeteFaction nThis() {
/*  652 */       return RoamCrossCompeteFaction.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  658 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction copy()
/*      */     {
/*  664 */       return RoamCrossCompeteFaction.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction toData()
/*      */     {
/*  670 */       return RoamCrossCompeteFaction.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteFaction toBean()
/*      */     {
/*  675 */       return RoamCrossCompeteFaction.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction toDataIf()
/*      */     {
/*  681 */       return RoamCrossCompeteFaction.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteFaction toBeanIf()
/*      */     {
/*  686 */       return RoamCrossCompeteFaction.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/*  693 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  694 */       return RoamCrossCompeteFaction.this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/*  701 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  702 */       return RoamCrossCompeteFaction.this.getNameOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */     {
/*  709 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  710 */       return xdb.Consts.constMap(RoamCrossCompeteFaction.this.duty2members);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */     {
/*  717 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*      */       
/*  719 */       RoamCrossCompeteFaction _o_ = RoamCrossCompeteFaction.this;
/*  720 */       Map<Integer, xbean.GangDutyMembers> duty2members = new HashMap();
/*  721 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  722 */         duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/*  723 */       return duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDesigned_titleid()
/*      */     {
/*  730 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  731 */       return RoamCrossCompeteFaction.this.designed_titleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/*  738 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  739 */       return RoamCrossCompeteFaction.this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_score()
/*      */     {
/*  746 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  747 */       return RoamCrossCompeteFaction.this.pk_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_score()
/*      */     {
/*  754 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  755 */       return RoamCrossCompeteFaction.this.player_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  762 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  763 */       return RoamCrossCompeteFaction.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_member_count()
/*      */     {
/*  770 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  771 */       return RoamCrossCompeteFaction.this.max_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/*  778 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  779 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/*  786 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  787 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDesigned_titleid(int _v_)
/*      */     {
/*  794 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  795 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/*  802 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  803 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_score(int _v_)
/*      */     {
/*  810 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  811 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_score(int _v_)
/*      */     {
/*  818 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  819 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/*  826 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  827 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_member_count(int _v_)
/*      */     {
/*  834 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  835 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  841 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  842 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  848 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  849 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  855 */       return RoamCrossCompeteFaction.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  861 */       return RoamCrossCompeteFaction.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  867 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  868 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  874 */       return RoamCrossCompeteFaction.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  880 */       return RoamCrossCompeteFaction.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  886 */       RoamCrossCompeteFaction.this._xdb_verify_unsafe_();
/*  887 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  893 */       return RoamCrossCompeteFaction.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  899 */       return RoamCrossCompeteFaction.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  905 */       return RoamCrossCompeteFaction.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  911 */       return RoamCrossCompeteFaction.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  917 */       return RoamCrossCompeteFaction.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  923 */       return RoamCrossCompeteFaction.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  929 */       return RoamCrossCompeteFaction.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoamCrossCompeteFaction
/*      */   {
/*      */     private String name;
/*      */     
/*      */     private HashMap<Integer, xbean.GangDutyMembers> duty2members;
/*      */     
/*      */     private int designed_titleid;
/*      */     
/*      */     private long opponent;
/*      */     
/*      */     private int pk_score;
/*      */     
/*      */     private int player_score;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int max_member_count;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  960 */       this.name = "";
/*  961 */       this.duty2members = new HashMap();
/*  962 */       this.pk_score = 0;
/*  963 */       this.player_score = 0;
/*  964 */       this.win_times = 0;
/*  965 */       this.max_member_count = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.RoamCrossCompeteFaction _o1_)
/*      */     {
/*  970 */       if ((_o1_ instanceof RoamCrossCompeteFaction)) { assign((RoamCrossCompeteFaction)_o1_);
/*  971 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  972 */       } else if ((_o1_ instanceof RoamCrossCompeteFaction.Const)) assign(((RoamCrossCompeteFaction.Const)_o1_).nThis()); else {
/*  973 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoamCrossCompeteFaction _o_) {
/*  978 */       this.name = _o_.name;
/*  979 */       this.duty2members = new HashMap();
/*  980 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  981 */         this.duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/*  982 */       this.designed_titleid = _o_.designed_titleid;
/*  983 */       this.opponent = _o_.opponent;
/*  984 */       this.pk_score = _o_.pk_score;
/*  985 */       this.player_score = _o_.player_score;
/*  986 */       this.win_times = _o_.win_times;
/*  987 */       this.max_member_count = _o_.max_member_count;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  992 */       this.name = _o_.name;
/*  993 */       this.duty2members = new HashMap();
/*  994 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : _o_.duty2members.entrySet())
/*  995 */         this.duty2members.put(_e_.getKey(), new GangDutyMembers.Data((xbean.GangDutyMembers)_e_.getValue()));
/*  996 */       this.designed_titleid = _o_.designed_titleid;
/*  997 */       this.opponent = _o_.opponent;
/*  998 */       this.pk_score = _o_.pk_score;
/*  999 */       this.player_score = _o_.player_score;
/* 1000 */       this.win_times = _o_.win_times;
/* 1001 */       this.max_member_count = _o_.max_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1007 */       _os_.marshal(this.name, "UTF-16LE");
/* 1008 */       _os_.compact_uint32(this.duty2members.size());
/* 1009 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 1011 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 1012 */         ((xbean.GangDutyMembers)_e_.getValue()).marshal(_os_);
/*      */       }
/* 1014 */       _os_.marshal(this.designed_titleid);
/* 1015 */       _os_.marshal(this.opponent);
/* 1016 */       _os_.marshal(this.pk_score);
/* 1017 */       _os_.marshal(this.player_score);
/* 1018 */       _os_.marshal(this.win_times);
/* 1019 */       _os_.marshal(this.max_member_count);
/* 1020 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1026 */       this.name = _os_.unmarshal_String("UTF-16LE");
/*      */       
/* 1028 */       int size = _os_.uncompact_uint32();
/* 1029 */       if (size >= 12)
/*      */       {
/* 1031 */         this.duty2members = new HashMap(size * 2);
/*      */       }
/* 1033 */       for (; size > 0; size--)
/*      */       {
/* 1035 */         int _k_ = 0;
/* 1036 */         _k_ = _os_.unmarshal_int();
/* 1037 */         xbean.GangDutyMembers _v_ = xbean.Pod.newGangDutyMembersData();
/* 1038 */         _v_.unmarshal(_os_);
/* 1039 */         this.duty2members.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1042 */       this.designed_titleid = _os_.unmarshal_int();
/* 1043 */       this.opponent = _os_.unmarshal_long();
/* 1044 */       this.pk_score = _os_.unmarshal_int();
/* 1045 */       this.player_score = _os_.unmarshal_int();
/* 1046 */       this.win_times = _os_.unmarshal_int();
/* 1047 */       this.max_member_count = _os_.unmarshal_int();
/* 1048 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1054 */       int _size_ = 0;
/*      */       try
/*      */       {
/* 1057 */         _size_ += CodedOutputStream.computeBytesSize(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1061 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1063 */       for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */       {
/* 1065 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/* 1066 */         _size_ += CodedOutputStream.computeMessageSize(2, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1068 */       _size_ += CodedOutputStream.computeInt32Size(3, this.designed_titleid);
/* 1069 */       _size_ += CodedOutputStream.computeInt64Size(4, this.opponent);
/* 1070 */       _size_ += CodedOutputStream.computeInt32Size(5, this.pk_score);
/* 1071 */       _size_ += CodedOutputStream.computeInt32Size(6, this.player_score);
/* 1072 */       _size_ += CodedOutputStream.computeInt32Size(7, this.win_times);
/* 1073 */       _size_ += CodedOutputStream.computeInt32Size(8, this.max_member_count);
/* 1074 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1082 */         _output_.writeBytes(1, ppbio.ByteString.copyFrom(this.name, "UTF-16LE"));
/* 1083 */         for (Map.Entry<Integer, xbean.GangDutyMembers> _e_ : this.duty2members.entrySet())
/*      */         {
/* 1085 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 1086 */           _output_.writeMessage(2, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1088 */         _output_.writeInt32(3, this.designed_titleid);
/* 1089 */         _output_.writeInt64(4, this.opponent);
/* 1090 */         _output_.writeInt32(5, this.pk_score);
/* 1091 */         _output_.writeInt32(6, this.player_score);
/* 1092 */         _output_.writeInt32(7, this.win_times);
/* 1093 */         _output_.writeInt32(8, this.max_member_count);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1097 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1099 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1107 */         boolean done = false;
/* 1108 */         while (!done)
/*      */         {
/* 1110 */           int tag = _input_.readTag();
/* 1111 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1115 */             done = true;
/* 1116 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1120 */             this.name = _input_.readBytes().toString("UTF-16LE");
/* 1121 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1125 */             int _k_ = 0;
/* 1126 */             _k_ = _input_.readInt32();
/* 1127 */             int readTag = _input_.readTag();
/* 1128 */             if (18 != readTag)
/*      */             {
/* 1130 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1132 */             xbean.GangDutyMembers _v_ = xbean.Pod.newGangDutyMembersData();
/* 1133 */             _input_.readMessage(_v_);
/* 1134 */             this.duty2members.put(Integer.valueOf(_k_), _v_);
/* 1135 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1139 */             this.designed_titleid = _input_.readInt32();
/* 1140 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1144 */             this.opponent = _input_.readInt64();
/* 1145 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1149 */             this.pk_score = _input_.readInt32();
/* 1150 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1154 */             this.player_score = _input_.readInt32();
/* 1155 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1159 */             this.win_times = _input_.readInt32();
/* 1160 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1164 */             this.max_member_count = _input_.readInt32();
/* 1165 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1169 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1171 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1180 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1184 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1186 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction copy()
/*      */     {
/* 1192 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction toData()
/*      */     {
/* 1198 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteFaction toBean()
/*      */     {
/* 1203 */       return new RoamCrossCompeteFaction(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoamCrossCompeteFaction toDataIf()
/*      */     {
/* 1209 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoamCrossCompeteFaction toBeanIf()
/*      */     {
/* 1214 */       return new RoamCrossCompeteFaction(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1220 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1224 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1228 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1232 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1236 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1240 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1244 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName()
/*      */     {
/* 1251 */       return this.name;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getNameOctets()
/*      */     {
/* 1258 */       return Octets.wrap(getName(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2members()
/*      */     {
/* 1265 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.GangDutyMembers> getDuty2membersAsData()
/*      */     {
/* 1272 */       return this.duty2members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDesigned_titleid()
/*      */     {
/* 1279 */       return this.designed_titleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/* 1286 */       return this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_score()
/*      */     {
/* 1293 */       return this.pk_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_score()
/*      */     {
/* 1300 */       return this.player_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1307 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMax_member_count()
/*      */     {
/* 1314 */       return this.max_member_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName(String _v_)
/*      */     {
/* 1321 */       if (null == _v_)
/* 1322 */         throw new NullPointerException();
/* 1323 */       this.name = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNameOctets(Octets _v_)
/*      */     {
/* 1330 */       setName(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDesigned_titleid(int _v_)
/*      */     {
/* 1337 */       this.designed_titleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/* 1344 */       this.opponent = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_score(int _v_)
/*      */     {
/* 1351 */       this.pk_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_score(int _v_)
/*      */     {
/* 1358 */       this.player_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1365 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMax_member_count(int _v_)
/*      */     {
/* 1372 */       this.max_member_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1378 */       if (!(_o1_ instanceof Data)) return false;
/* 1379 */       Data _o_ = (Data)_o1_;
/* 1380 */       if (!this.name.equals(_o_.name)) return false;
/* 1381 */       if (!this.duty2members.equals(_o_.duty2members)) return false;
/* 1382 */       if (this.designed_titleid != _o_.designed_titleid) return false;
/* 1383 */       if (this.opponent != _o_.opponent) return false;
/* 1384 */       if (this.pk_score != _o_.pk_score) return false;
/* 1385 */       if (this.player_score != _o_.player_score) return false;
/* 1386 */       if (this.win_times != _o_.win_times) return false;
/* 1387 */       if (this.max_member_count != _o_.max_member_count) return false;
/* 1388 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1394 */       int _h_ = 0;
/* 1395 */       _h_ += this.name.hashCode();
/* 1396 */       _h_ += this.duty2members.hashCode();
/* 1397 */       _h_ += this.designed_titleid;
/* 1398 */       _h_ = (int)(_h_ + this.opponent);
/* 1399 */       _h_ += this.pk_score;
/* 1400 */       _h_ += this.player_score;
/* 1401 */       _h_ += this.win_times;
/* 1402 */       _h_ += this.max_member_count;
/* 1403 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1409 */       StringBuilder _sb_ = new StringBuilder();
/* 1410 */       _sb_.append("(");
/* 1411 */       _sb_.append("'").append(this.name).append("'");
/* 1412 */       _sb_.append(",");
/* 1413 */       _sb_.append(this.duty2members);
/* 1414 */       _sb_.append(",");
/* 1415 */       _sb_.append(this.designed_titleid);
/* 1416 */       _sb_.append(",");
/* 1417 */       _sb_.append(this.opponent);
/* 1418 */       _sb_.append(",");
/* 1419 */       _sb_.append(this.pk_score);
/* 1420 */       _sb_.append(",");
/* 1421 */       _sb_.append(this.player_score);
/* 1422 */       _sb_.append(",");
/* 1423 */       _sb_.append(this.win_times);
/* 1424 */       _sb_.append(",");
/* 1425 */       _sb_.append(this.max_member_count);
/* 1426 */       _sb_.append(")");
/* 1427 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoamCrossCompeteFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */