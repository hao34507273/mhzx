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
/*      */ import ppbio.Message;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class ChatGift extends XBean implements xbean.ChatGift
/*      */ {
/*      */   private long roleid;
/*      */   private long starttime;
/*      */   private int type;
/*      */   private HashMap<Long, xbean.ChatGiftRoleMoney> role2money;
/*      */   private int num;
/*      */   private String descstr;
/*      */   private HashMap<Integer, xbean.ChannelSet> channelinfo;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.roleid = 0L;
/*   31 */     this.starttime = 0L;
/*   32 */     this.type = 0;
/*   33 */     this.role2money.clear();
/*   34 */     this.num = 0;
/*   35 */     this.descstr = "";
/*   36 */     this.channelinfo.clear();
/*      */   }
/*      */   
/*      */   ChatGift(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.role2money = new HashMap();
/*   43 */     this.descstr = "";
/*   44 */     this.channelinfo = new HashMap();
/*      */   }
/*      */   
/*      */   public ChatGift()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public ChatGift(ChatGift _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   ChatGift(xbean.ChatGift _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof ChatGift)) { assign((ChatGift)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(ChatGift _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.roleid = _o_.roleid;
/*   70 */     this.starttime = _o_.starttime;
/*   71 */     this.type = _o_.type;
/*   72 */     this.role2money = new HashMap();
/*   73 */     for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*   74 */       this.role2money.put(_e_.getKey(), new ChatGiftRoleMoney((xbean.ChatGiftRoleMoney)_e_.getValue(), this, "role2money"));
/*   75 */     this.num = _o_.num;
/*   76 */     this.descstr = _o_.descstr;
/*   77 */     this.channelinfo = new HashMap();
/*   78 */     for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet()) {
/*   79 */       this.channelinfo.put(_e_.getKey(), new ChannelSet((xbean.ChannelSet)_e_.getValue(), this, "channelinfo"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   84 */     this.roleid = _o_.roleid;
/*   85 */     this.starttime = _o_.starttime;
/*   86 */     this.type = _o_.type;
/*   87 */     this.role2money = new HashMap();
/*   88 */     for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*   89 */       this.role2money.put(_e_.getKey(), new ChatGiftRoleMoney((xbean.ChatGiftRoleMoney)_e_.getValue(), this, "role2money"));
/*   90 */     this.num = _o_.num;
/*   91 */     this.descstr = _o_.descstr;
/*   92 */     this.channelinfo = new HashMap();
/*   93 */     for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet()) {
/*   94 */       this.channelinfo.put(_e_.getKey(), new ChannelSet((xbean.ChannelSet)_e_.getValue(), this, "channelinfo"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     _os_.marshal(this.roleid);
/*  102 */     _os_.marshal(this.starttime);
/*  103 */     _os_.marshal(this.type);
/*  104 */     _os_.compact_uint32(this.role2money.size());
/*  105 */     for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */     {
/*  107 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  108 */       ((xbean.ChatGiftRoleMoney)_e_.getValue()).marshal(_os_);
/*      */     }
/*  110 */     _os_.marshal(this.num);
/*  111 */     _os_.marshal(this.descstr, "UTF-16LE");
/*  112 */     _os_.compact_uint32(this.channelinfo.size());
/*  113 */     for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */     {
/*  115 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  116 */       ((xbean.ChannelSet)_e_.getValue()).marshal(_os_);
/*      */     }
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     this.roleid = _os_.unmarshal_long();
/*  126 */     this.starttime = _os_.unmarshal_long();
/*  127 */     this.type = _os_.unmarshal_int();
/*      */     
/*  129 */     int size = _os_.uncompact_uint32();
/*  130 */     if (size >= 12)
/*      */     {
/*  132 */       this.role2money = new HashMap(size * 2);
/*      */     }
/*  134 */     for (; size > 0; size--)
/*      */     {
/*  136 */       long _k_ = 0L;
/*  137 */       _k_ = _os_.unmarshal_long();
/*  138 */       xbean.ChatGiftRoleMoney _v_ = new ChatGiftRoleMoney(0, this, "role2money");
/*  139 */       _v_.unmarshal(_os_);
/*  140 */       this.role2money.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  143 */     this.num = _os_.unmarshal_int();
/*  144 */     this.descstr = _os_.unmarshal_String("UTF-16LE");
/*      */     
/*  146 */     int size = _os_.uncompact_uint32();
/*  147 */     if (size >= 12)
/*      */     {
/*  149 */       this.channelinfo = new HashMap(size * 2);
/*      */     }
/*  151 */     for (; size > 0; size--)
/*      */     {
/*  153 */       int _k_ = 0;
/*  154 */       _k_ = _os_.unmarshal_int();
/*  155 */       xbean.ChannelSet _v_ = new ChannelSet(0, this, "channelinfo");
/*  156 */       _v_.unmarshal(_os_);
/*  157 */       this.channelinfo.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  160 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*  167 */     int _size_ = 0;
/*  168 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*  169 */     _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*  170 */     _size_ += CodedOutputStream.computeInt32Size(3, this.type);
/*  171 */     for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */     {
/*  173 */       _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/*  174 */       _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */     }
/*  176 */     _size_ += CodedOutputStream.computeInt32Size(5, this.num);
/*      */     try
/*      */     {
/*  179 */       _size_ += CodedOutputStream.computeBytesSize(6, ppbio.ByteString.copyFrom(this.descstr, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  183 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  185 */     for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */     {
/*  187 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/*  188 */       _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */     }
/*  190 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  196 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  199 */       _output_.writeInt64(1, this.roleid);
/*  200 */       _output_.writeInt64(2, this.starttime);
/*  201 */       _output_.writeInt32(3, this.type);
/*  202 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */       {
/*  204 */         _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/*  205 */         _output_.writeMessage(4, (Message)_e_.getValue());
/*      */       }
/*  207 */       _output_.writeInt32(5, this.num);
/*  208 */       _output_.writeBytes(6, ppbio.ByteString.copyFrom(this.descstr, "UTF-16LE"));
/*  209 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */       {
/*  211 */         _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/*  212 */         _output_.writeMessage(7, (Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  217 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  219 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  228 */       boolean done = false;
/*  229 */       while (!done)
/*      */       {
/*  231 */         int tag = _input_.readTag();
/*  232 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  236 */           done = true;
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  241 */           this.roleid = _input_.readInt64();
/*  242 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  246 */           this.starttime = _input_.readInt64();
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  251 */           this.type = _input_.readInt32();
/*  252 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  256 */           long _k_ = 0L;
/*  257 */           _k_ = _input_.readInt64();
/*  258 */           int readTag = _input_.readTag();
/*  259 */           if (34 != readTag)
/*      */           {
/*  261 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  263 */           xbean.ChatGiftRoleMoney _v_ = new ChatGiftRoleMoney(0, this, "role2money");
/*  264 */           _input_.readMessage(_v_);
/*  265 */           this.role2money.put(Long.valueOf(_k_), _v_);
/*  266 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  270 */           this.num = _input_.readInt32();
/*  271 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  275 */           this.descstr = _input_.readBytes().toString("UTF-16LE");
/*  276 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  280 */           int _k_ = 0;
/*  281 */           _k_ = _input_.readInt32();
/*  282 */           int readTag = _input_.readTag();
/*  283 */           if (58 != readTag)
/*      */           {
/*  285 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  287 */           xbean.ChannelSet _v_ = new ChannelSet(0, this, "channelinfo");
/*  288 */           _input_.readMessage(_v_);
/*  289 */           this.channelinfo.put(Integer.valueOf(_k_), _v_);
/*  290 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  294 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  296 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  305 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  309 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  311 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChatGift copy()
/*      */   {
/*  317 */     _xdb_verify_unsafe_();
/*  318 */     return new ChatGift(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChatGift toData()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChatGift toBean()
/*      */   {
/*  330 */     _xdb_verify_unsafe_();
/*  331 */     return new ChatGift(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.ChatGift toDataIf()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.ChatGift toBeanIf()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getType()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*  375 */     return this.type;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChatGiftRoleMoney> getRole2money()
/*      */   {
/*  382 */     _xdb_verify_unsafe_();
/*  383 */     return xdb.Logs.logMap(new LogKey(this, "role2money"), this.role2money);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.ChatGiftRoleMoney> getRole2moneyAsData()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*      */     
/*  392 */     ChatGift _o_ = this;
/*  393 */     Map<Long, xbean.ChatGiftRoleMoney> role2money = new HashMap();
/*  394 */     for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*  395 */       role2money.put(_e_.getKey(), new ChatGiftRoleMoney.Data((xbean.ChatGiftRoleMoney)_e_.getValue()));
/*  396 */     return role2money;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getNum()
/*      */   {
/*  403 */     _xdb_verify_unsafe_();
/*  404 */     return this.num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getDescstr()
/*      */   {
/*  411 */     _xdb_verify_unsafe_();
/*  412 */     return this.descstr;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getDescstrOctets()
/*      */   {
/*  419 */     _xdb_verify_unsafe_();
/*  420 */     return Octets.wrap(getDescstr(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChannelSet> getChannelinfo()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return xdb.Logs.logMap(new LogKey(this, "channelinfo"), this.channelinfo);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.ChannelSet> getChannelinfoAsData()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*      */     
/*  437 */     ChatGift _o_ = this;
/*  438 */     Map<Integer, xbean.ChannelSet> channelinfo = new HashMap();
/*  439 */     for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet())
/*  440 */       channelinfo.put(_e_.getKey(), new ChannelSet.Data((xbean.ChannelSet)_e_.getValue()));
/*  441 */     return channelinfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  448 */     _xdb_verify_unsafe_();
/*  449 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  453 */         new xdb.logs.LogLong(this, ChatGift.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  457 */             ChatGift.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  461 */     });
/*  462 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  469 */     _xdb_verify_unsafe_();
/*  470 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  474 */         new xdb.logs.LogLong(this, ChatGift.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  478 */             ChatGift.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  482 */     });
/*  483 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setType(int _v_)
/*      */   {
/*  490 */     _xdb_verify_unsafe_();
/*  491 */     xdb.Logs.logIf(new LogKey(this, "type")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  495 */         new xdb.logs.LogInt(this, ChatGift.this.type)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  499 */             ChatGift.this.type = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  503 */     });
/*  504 */     this.type = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setNum(int _v_)
/*      */   {
/*  511 */     _xdb_verify_unsafe_();
/*  512 */     xdb.Logs.logIf(new LogKey(this, "num")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  516 */         new xdb.logs.LogInt(this, ChatGift.this.num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  520 */             ChatGift.this.num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  524 */     });
/*  525 */     this.num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDescstr(String _v_)
/*      */   {
/*  532 */     _xdb_verify_unsafe_();
/*  533 */     if (null == _v_)
/*  534 */       throw new NullPointerException();
/*  535 */     xdb.Logs.logIf(new LogKey(this, "descstr")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  539 */         new xdb.logs.LogString(this, ChatGift.this.descstr)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  543 */             ChatGift.this.descstr = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  547 */     });
/*  548 */     this.descstr = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDescstrOctets(Octets _v_)
/*      */   {
/*  555 */     _xdb_verify_unsafe_();
/*  556 */     setDescstr(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  562 */     _xdb_verify_unsafe_();
/*  563 */     ChatGift _o_ = null;
/*  564 */     if ((_o1_ instanceof ChatGift)) { _o_ = (ChatGift)_o1_;
/*  565 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  566 */       return false;
/*  567 */     if (this.roleid != _o_.roleid) return false;
/*  568 */     if (this.starttime != _o_.starttime) return false;
/*  569 */     if (this.type != _o_.type) return false;
/*  570 */     if (!this.role2money.equals(_o_.role2money)) return false;
/*  571 */     if (this.num != _o_.num) return false;
/*  572 */     if (!this.descstr.equals(_o_.descstr)) return false;
/*  573 */     if (!this.channelinfo.equals(_o_.channelinfo)) return false;
/*  574 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  580 */     _xdb_verify_unsafe_();
/*  581 */     int _h_ = 0;
/*  582 */     _h_ = (int)(_h_ + this.roleid);
/*  583 */     _h_ = (int)(_h_ + this.starttime);
/*  584 */     _h_ += this.type;
/*  585 */     _h_ += this.role2money.hashCode();
/*  586 */     _h_ += this.num;
/*  587 */     _h_ += this.descstr.hashCode();
/*  588 */     _h_ += this.channelinfo.hashCode();
/*  589 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  595 */     _xdb_verify_unsafe_();
/*  596 */     StringBuilder _sb_ = new StringBuilder();
/*  597 */     _sb_.append("(");
/*  598 */     _sb_.append(this.roleid);
/*  599 */     _sb_.append(",");
/*  600 */     _sb_.append(this.starttime);
/*  601 */     _sb_.append(",");
/*  602 */     _sb_.append(this.type);
/*  603 */     _sb_.append(",");
/*  604 */     _sb_.append(this.role2money);
/*  605 */     _sb_.append(",");
/*  606 */     _sb_.append(this.num);
/*  607 */     _sb_.append(",");
/*  608 */     _sb_.append("'").append(this.descstr).append("'");
/*  609 */     _sb_.append(",");
/*  610 */     _sb_.append(this.channelinfo);
/*  611 */     _sb_.append(")");
/*  612 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  618 */     ListenableBean lb = new ListenableBean();
/*  619 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  620 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  621 */     lb.add(new ListenableChanged().setVarName("type"));
/*  622 */     lb.add(new xdb.logs.ListenableMap().setVarName("role2money"));
/*  623 */     lb.add(new ListenableChanged().setVarName("num"));
/*  624 */     lb.add(new ListenableChanged().setVarName("descstr"));
/*  625 */     lb.add(new xdb.logs.ListenableMap().setVarName("channelinfo"));
/*  626 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.ChatGift {
/*      */     private Const() {}
/*      */     
/*      */     ChatGift nThis() {
/*  633 */       return ChatGift.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  639 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift copy()
/*      */     {
/*  645 */       return ChatGift.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift toData()
/*      */     {
/*  651 */       return ChatGift.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.ChatGift toBean()
/*      */     {
/*  656 */       return ChatGift.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift toDataIf()
/*      */     {
/*  662 */       return ChatGift.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.ChatGift toBeanIf()
/*      */     {
/*  667 */       return ChatGift.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  674 */       ChatGift.this._xdb_verify_unsafe_();
/*  675 */       return ChatGift.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  682 */       ChatGift.this._xdb_verify_unsafe_();
/*  683 */       return ChatGift.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/*  690 */       ChatGift.this._xdb_verify_unsafe_();
/*  691 */       return ChatGift.this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatGiftRoleMoney> getRole2money()
/*      */     {
/*  698 */       ChatGift.this._xdb_verify_unsafe_();
/*  699 */       return xdb.Consts.constMap(ChatGift.this.role2money);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatGiftRoleMoney> getRole2moneyAsData()
/*      */     {
/*  706 */       ChatGift.this._xdb_verify_unsafe_();
/*      */       
/*  708 */       ChatGift _o_ = ChatGift.this;
/*  709 */       Map<Long, xbean.ChatGiftRoleMoney> role2money = new HashMap();
/*  710 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*  711 */         role2money.put(_e_.getKey(), new ChatGiftRoleMoney.Data((xbean.ChatGiftRoleMoney)_e_.getValue()));
/*  712 */       return role2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNum()
/*      */     {
/*  719 */       ChatGift.this._xdb_verify_unsafe_();
/*  720 */       return ChatGift.this.num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getDescstr()
/*      */     {
/*  727 */       ChatGift.this._xdb_verify_unsafe_();
/*  728 */       return ChatGift.this.descstr;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getDescstrOctets()
/*      */     {
/*  735 */       ChatGift.this._xdb_verify_unsafe_();
/*  736 */       return ChatGift.this.getDescstrOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChannelSet> getChannelinfo()
/*      */     {
/*  743 */       ChatGift.this._xdb_verify_unsafe_();
/*  744 */       return xdb.Consts.constMap(ChatGift.this.channelinfo);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChannelSet> getChannelinfoAsData()
/*      */     {
/*  751 */       ChatGift.this._xdb_verify_unsafe_();
/*      */       
/*  753 */       ChatGift _o_ = ChatGift.this;
/*  754 */       Map<Integer, xbean.ChannelSet> channelinfo = new HashMap();
/*  755 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet())
/*  756 */         channelinfo.put(_e_.getKey(), new ChannelSet.Data((xbean.ChannelSet)_e_.getValue()));
/*  757 */       return channelinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  764 */       ChatGift.this._xdb_verify_unsafe_();
/*  765 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  772 */       ChatGift.this._xdb_verify_unsafe_();
/*  773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/*  780 */       ChatGift.this._xdb_verify_unsafe_();
/*  781 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNum(int _v_)
/*      */     {
/*  788 */       ChatGift.this._xdb_verify_unsafe_();
/*  789 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDescstr(String _v_)
/*      */     {
/*  796 */       ChatGift.this._xdb_verify_unsafe_();
/*  797 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDescstrOctets(Octets _v_)
/*      */     {
/*  804 */       ChatGift.this._xdb_verify_unsafe_();
/*  805 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  811 */       ChatGift.this._xdb_verify_unsafe_();
/*  812 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  818 */       ChatGift.this._xdb_verify_unsafe_();
/*  819 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  825 */       return ChatGift.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  831 */       return ChatGift.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  837 */       ChatGift.this._xdb_verify_unsafe_();
/*  838 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  844 */       return ChatGift.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  850 */       return ChatGift.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  856 */       ChatGift.this._xdb_verify_unsafe_();
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  863 */       return ChatGift.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  869 */       return ChatGift.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  875 */       return ChatGift.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  881 */       return ChatGift.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  887 */       return ChatGift.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  893 */       return ChatGift.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  899 */       return ChatGift.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.ChatGift
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private long starttime;
/*      */     
/*      */     private int type;
/*      */     
/*      */     private HashMap<Long, xbean.ChatGiftRoleMoney> role2money;
/*      */     
/*      */     private int num;
/*      */     
/*      */     private String descstr;
/*      */     
/*      */     private HashMap<Integer, xbean.ChannelSet> channelinfo;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  923 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  928 */       this.role2money = new HashMap();
/*  929 */       this.descstr = "";
/*  930 */       this.channelinfo = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.ChatGift _o1_)
/*      */     {
/*  935 */       if ((_o1_ instanceof ChatGift)) { assign((ChatGift)_o1_);
/*  936 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  937 */       } else if ((_o1_ instanceof ChatGift.Const)) assign(((ChatGift.Const)_o1_).nThis()); else {
/*  938 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(ChatGift _o_) {
/*  943 */       this.roleid = _o_.roleid;
/*  944 */       this.starttime = _o_.starttime;
/*  945 */       this.type = _o_.type;
/*  946 */       this.role2money = new HashMap();
/*  947 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*  948 */         this.role2money.put(_e_.getKey(), new ChatGiftRoleMoney.Data((xbean.ChatGiftRoleMoney)_e_.getValue()));
/*  949 */       this.num = _o_.num;
/*  950 */       this.descstr = _o_.descstr;
/*  951 */       this.channelinfo = new HashMap();
/*  952 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet()) {
/*  953 */         this.channelinfo.put(_e_.getKey(), new ChannelSet.Data((xbean.ChannelSet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  958 */       this.roleid = _o_.roleid;
/*  959 */       this.starttime = _o_.starttime;
/*  960 */       this.type = _o_.type;
/*  961 */       this.role2money = new HashMap();
/*  962 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : _o_.role2money.entrySet())
/*  963 */         this.role2money.put(_e_.getKey(), new ChatGiftRoleMoney.Data((xbean.ChatGiftRoleMoney)_e_.getValue()));
/*  964 */       this.num = _o_.num;
/*  965 */       this.descstr = _o_.descstr;
/*  966 */       this.channelinfo = new HashMap();
/*  967 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : _o_.channelinfo.entrySet()) {
/*  968 */         this.channelinfo.put(_e_.getKey(), new ChannelSet.Data((xbean.ChannelSet)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  974 */       _os_.marshal(this.roleid);
/*  975 */       _os_.marshal(this.starttime);
/*  976 */       _os_.marshal(this.type);
/*  977 */       _os_.compact_uint32(this.role2money.size());
/*  978 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */       {
/*  980 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  981 */         ((xbean.ChatGiftRoleMoney)_e_.getValue()).marshal(_os_);
/*      */       }
/*  983 */       _os_.marshal(this.num);
/*  984 */       _os_.marshal(this.descstr, "UTF-16LE");
/*  985 */       _os_.compact_uint32(this.channelinfo.size());
/*  986 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */       {
/*  988 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  989 */         ((xbean.ChannelSet)_e_.getValue()).marshal(_os_);
/*      */       }
/*  991 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  997 */       this.roleid = _os_.unmarshal_long();
/*  998 */       this.starttime = _os_.unmarshal_long();
/*  999 */       this.type = _os_.unmarshal_int();
/*      */       
/* 1001 */       int size = _os_.uncompact_uint32();
/* 1002 */       if (size >= 12)
/*      */       {
/* 1004 */         this.role2money = new HashMap(size * 2);
/*      */       }
/* 1006 */       for (; size > 0; size--)
/*      */       {
/* 1008 */         long _k_ = 0L;
/* 1009 */         _k_ = _os_.unmarshal_long();
/* 1010 */         xbean.ChatGiftRoleMoney _v_ = xbean.Pod.newChatGiftRoleMoneyData();
/* 1011 */         _v_.unmarshal(_os_);
/* 1012 */         this.role2money.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1015 */       this.num = _os_.unmarshal_int();
/* 1016 */       this.descstr = _os_.unmarshal_String("UTF-16LE");
/*      */       
/* 1018 */       int size = _os_.uncompact_uint32();
/* 1019 */       if (size >= 12)
/*      */       {
/* 1021 */         this.channelinfo = new HashMap(size * 2);
/*      */       }
/* 1023 */       for (; size > 0; size--)
/*      */       {
/* 1025 */         int _k_ = 0;
/* 1026 */         _k_ = _os_.unmarshal_int();
/* 1027 */         xbean.ChannelSet _v_ = xbean.Pod.newChannelSetData();
/* 1028 */         _v_.unmarshal(_os_);
/* 1029 */         this.channelinfo.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/* 1032 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1038 */       int _size_ = 0;
/* 1039 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/* 1040 */       _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/* 1041 */       _size_ += CodedOutputStream.computeInt32Size(3, this.type);
/* 1042 */       for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */       {
/* 1044 */         _size_ += CodedOutputStream.computeInt64Size(4, ((Long)_e_.getKey()).longValue());
/* 1045 */         _size_ += CodedOutputStream.computeMessageSize(4, (Message)_e_.getValue());
/*      */       }
/* 1047 */       _size_ += CodedOutputStream.computeInt32Size(5, this.num);
/*      */       try
/*      */       {
/* 1050 */         _size_ += CodedOutputStream.computeBytesSize(6, ppbio.ByteString.copyFrom(this.descstr, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1054 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1056 */       for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */       {
/* 1058 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getKey()).intValue());
/* 1059 */         _size_ += CodedOutputStream.computeMessageSize(7, (Message)_e_.getValue());
/*      */       }
/* 1061 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1069 */         _output_.writeInt64(1, this.roleid);
/* 1070 */         _output_.writeInt64(2, this.starttime);
/* 1071 */         _output_.writeInt32(3, this.type);
/* 1072 */         for (Map.Entry<Long, xbean.ChatGiftRoleMoney> _e_ : this.role2money.entrySet())
/*      */         {
/* 1074 */           _output_.writeInt64(4, ((Long)_e_.getKey()).longValue());
/* 1075 */           _output_.writeMessage(4, (Message)_e_.getValue());
/*      */         }
/* 1077 */         _output_.writeInt32(5, this.num);
/* 1078 */         _output_.writeBytes(6, ppbio.ByteString.copyFrom(this.descstr, "UTF-16LE"));
/* 1079 */         for (Map.Entry<Integer, xbean.ChannelSet> _e_ : this.channelinfo.entrySet())
/*      */         {
/* 1081 */           _output_.writeInt32(7, ((Integer)_e_.getKey()).intValue());
/* 1082 */           _output_.writeMessage(7, (Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1087 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1089 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1097 */         boolean done = false;
/* 1098 */         while (!done)
/*      */         {
/* 1100 */           int tag = _input_.readTag();
/* 1101 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1105 */             done = true;
/* 1106 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1110 */             this.roleid = _input_.readInt64();
/* 1111 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1115 */             this.starttime = _input_.readInt64();
/* 1116 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1120 */             this.type = _input_.readInt32();
/* 1121 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1125 */             long _k_ = 0L;
/* 1126 */             _k_ = _input_.readInt64();
/* 1127 */             int readTag = _input_.readTag();
/* 1128 */             if (34 != readTag)
/*      */             {
/* 1130 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1132 */             xbean.ChatGiftRoleMoney _v_ = xbean.Pod.newChatGiftRoleMoneyData();
/* 1133 */             _input_.readMessage(_v_);
/* 1134 */             this.role2money.put(Long.valueOf(_k_), _v_);
/* 1135 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1139 */             this.num = _input_.readInt32();
/* 1140 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1144 */             this.descstr = _input_.readBytes().toString("UTF-16LE");
/* 1145 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1149 */             int _k_ = 0;
/* 1150 */             _k_ = _input_.readInt32();
/* 1151 */             int readTag = _input_.readTag();
/* 1152 */             if (58 != readTag)
/*      */             {
/* 1154 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1156 */             xbean.ChannelSet _v_ = xbean.Pod.newChannelSetData();
/* 1157 */             _input_.readMessage(_v_);
/* 1158 */             this.channelinfo.put(Integer.valueOf(_k_), _v_);
/* 1159 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1163 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1165 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1174 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1178 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1180 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift copy()
/*      */     {
/* 1186 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift toData()
/*      */     {
/* 1192 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.ChatGift toBean()
/*      */     {
/* 1197 */       return new ChatGift(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.ChatGift toDataIf()
/*      */     {
/* 1203 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.ChatGift toBeanIf()
/*      */     {
/* 1208 */       return new ChatGift(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1214 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1218 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1222 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1226 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1230 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1234 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1238 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1245 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/* 1252 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getType()
/*      */     {
/* 1259 */       return this.type;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatGiftRoleMoney> getRole2money()
/*      */     {
/* 1266 */       return this.role2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.ChatGiftRoleMoney> getRole2moneyAsData()
/*      */     {
/* 1273 */       return this.role2money;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getNum()
/*      */     {
/* 1280 */       return this.num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getDescstr()
/*      */     {
/* 1287 */       return this.descstr;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getDescstrOctets()
/*      */     {
/* 1294 */       return Octets.wrap(getDescstr(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChannelSet> getChannelinfo()
/*      */     {
/* 1301 */       return this.channelinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.ChannelSet> getChannelinfoAsData()
/*      */     {
/* 1308 */       return this.channelinfo;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1315 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/* 1322 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setType(int _v_)
/*      */     {
/* 1329 */       this.type = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setNum(int _v_)
/*      */     {
/* 1336 */       this.num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDescstr(String _v_)
/*      */     {
/* 1343 */       if (null == _v_)
/* 1344 */         throw new NullPointerException();
/* 1345 */       this.descstr = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDescstrOctets(Octets _v_)
/*      */     {
/* 1352 */       setDescstr(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1358 */       if (!(_o1_ instanceof Data)) return false;
/* 1359 */       Data _o_ = (Data)_o1_;
/* 1360 */       if (this.roleid != _o_.roleid) return false;
/* 1361 */       if (this.starttime != _o_.starttime) return false;
/* 1362 */       if (this.type != _o_.type) return false;
/* 1363 */       if (!this.role2money.equals(_o_.role2money)) return false;
/* 1364 */       if (this.num != _o_.num) return false;
/* 1365 */       if (!this.descstr.equals(_o_.descstr)) return false;
/* 1366 */       if (!this.channelinfo.equals(_o_.channelinfo)) return false;
/* 1367 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1373 */       int _h_ = 0;
/* 1374 */       _h_ = (int)(_h_ + this.roleid);
/* 1375 */       _h_ = (int)(_h_ + this.starttime);
/* 1376 */       _h_ += this.type;
/* 1377 */       _h_ += this.role2money.hashCode();
/* 1378 */       _h_ += this.num;
/* 1379 */       _h_ += this.descstr.hashCode();
/* 1380 */       _h_ += this.channelinfo.hashCode();
/* 1381 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1387 */       StringBuilder _sb_ = new StringBuilder();
/* 1388 */       _sb_.append("(");
/* 1389 */       _sb_.append(this.roleid);
/* 1390 */       _sb_.append(",");
/* 1391 */       _sb_.append(this.starttime);
/* 1392 */       _sb_.append(",");
/* 1393 */       _sb_.append(this.type);
/* 1394 */       _sb_.append(",");
/* 1395 */       _sb_.append(this.role2money);
/* 1396 */       _sb_.append(",");
/* 1397 */       _sb_.append(this.num);
/* 1398 */       _sb_.append(",");
/* 1399 */       _sb_.append("'").append(this.descstr).append("'");
/* 1400 */       _sb_.append(",");
/* 1401 */       _sb_.append(this.channelinfo);
/* 1402 */       _sb_.append(")");
/* 1403 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChatGift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */